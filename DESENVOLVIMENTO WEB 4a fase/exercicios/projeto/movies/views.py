from django.shortcuts import render, redirect, get_object_or_404
from .models import Movie
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login, logout


@login_required(login_url='login')
def index(request):
    movies = Movie.objects.all()
    return render(request, "movies/movie_list.html", {'movies': movies})

def login_view(request):
    if request.method == "POST":
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(request, username=username, password=password)
        if user is not None:
            login(request, user)
            return redirect("index")
        else:
            error_message = "Invalid username or password."
            return render(request, "movies/login.html", {'error_message': error_message})
    return render(request, "movies/login.html")

@login_required(login_url='login')
def create_movie(request):
    if request.method == "POST":
        title = request.POST.get('title')
        release_year = request.POST.get('release_year')
        director = request.POST.get('director')
        description = request.POST.get('description')
        image = request.FILES.get('image')
        movie = Movie.objects.create(title=title, release_year=release_year, director=director, description=description, image=image)
        movie.save()
        return redirect("index")
    return render(request, "movies/movie_create.html")


@login_required(login_url='login')
def edit_movie(request, movie_id):
    movie = get_object_or_404(Movie, id=movie_id)
    if request.method == "POST":
        title = request.POST.get('title')
        release_year = request.POST.get('release_year')
        director = request.POST.get('director')
        description = request.POST.get('description')
        image = request.FILES.get('image')
        movie.title = title
        movie.release_year = release_year
        movie.director = director
        movie.description = description
        movie.image = image
        movie.save()
        return redirect("index")
    else:
        return render(request, "movies/movie_edit.html", {'movie': movie})



@login_required(login_url='login')
def delete_movie(request, movie_id):
    movie = get_object_or_404(Movie, id=movie_id)
    if request.method == "POST":
        movie.delete()
        return redirect("index")
    return render(request, "movies/movie_delete.html", {'movie': movie})

@login_required(login_url='login')
def movie_detail(request, movie_id):
    movie = get_object_or_404(Movie, id=movie_id)
    return render(request, "movies/movie_detail.html", {'movie': movie})

@login_required(login_url='login', redirect_field_name='index')
def logout_view(request):
    logout(request)
    return redirect('index')
