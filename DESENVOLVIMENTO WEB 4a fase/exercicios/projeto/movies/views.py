from django.shortcuts import render
from django.http import HttpResponse

from .models import Movie

# Create your views here.

def index(request):
    movies = Movie.objects.all()
    for movie in movies:
        print(movie.title)
    return render(request, "movies/movie_list.html", {'movies': movies})
