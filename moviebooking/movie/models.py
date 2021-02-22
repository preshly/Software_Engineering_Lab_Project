from django.db import models


class Movie(models.Model):
    movie_id = models.AutoField
    movie_name = models.CharField(max_length=50)
    movie_language = models.CharField(max_length=30)
    movie_duration = models.IntegerField()

    def __str__(self):
        return self.movie_name
