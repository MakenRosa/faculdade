from django.db import models

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=64)
    release_year = models.IntegerField()
    director = models.CharField(max_length=64)
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)