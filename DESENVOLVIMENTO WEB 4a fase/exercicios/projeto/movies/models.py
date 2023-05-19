from django.db import models

def movie_image_path(instance, filename):
    return f'movie_images/{instance.id}/{filename}'

class Movie(models.Model):
    title = models.CharField(max_length=64)
    release_year = models.IntegerField()
    director = models.CharField(max_length=64)
    description = models.TextField()
    image = models.ImageField()
    created_at = models.DateTimeField(auto_now_add=True)
