from django.db import models
from django.core.validators import MinLengthValidator
from datetime import datetime

class Movie(models.Model):
    movie_id = models.AutoField
    movie_name = models.CharField(max_length=50)
    movie_language = models.CharField(max_length=30)
    movie_duration = models.IntegerField()
    movie_description = models.CharField(max_length=256, default="")
    movie_release_date = models.DateField(default=datetime.now)
    image = models.ImageField(upload_to='media/images', default="")
    def __str__(self):
        return self.movie_name

class Genre(models.Model):
    genre_id = models.AutoField
    genre_name = models.CharField(max_length=50)


    def __str__(self):
        return self.genre_name

class Customer(models.Model):
    cust_id = models.AutoField
    email = models.EmailField()
    username = models.CharField(max_length=6, validators=[MinLengthValidator(6)])
    password = models.CharField(max_length=8, validators=[MinLengthValidator(8)])
    is_active = models.BooleanField(default = False)  
    def __str__(self):
        return self.username
