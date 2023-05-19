from django.urls import path
from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("login/", views.login_view, name="login"),
    path("logout/", views.logout_view, name="logout"),
    path("create/", views.create_movie, name="create_movie"),
    path("edit/<int:movie_id>/", views.edit_movie, name="edit_movie"),
    path("delete/<int:movie_id>/", views.delete_movie, name="delete_movie"),
    path("movie/<int:movie_id>/", views.movie_detail, name="movie_detail"),
]
