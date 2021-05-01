from django.db import models
from django.core.validators import MinLengthValidator, MaxValueValidator
from datetime import datetime

class Movie(models.Model):
    movie_id = models.AutoField
    movie_name = models.CharField(max_length=50)
    movie_language = models.CharField(max_length=30)
    movie_duration = models.IntegerField()
    movie_description = models.CharField(max_length=256, default="")
    movie_release_date = models.DateField(default=datetime.now)
    image = models.ImageField(upload_to='media/images', default="")
    is_screening = models.BooleanField(default=False)
    def __str__(self):
        return self.movie_name

class Genre(models.Model):
    genre_id = models.AutoField
    genre_name = models.CharField(max_length=50)


    def __str__(self):
        return self.genre_name

class Customer(models.Model):
    #cust_id = models.AutoField
    email = models.EmailField()
    username = models.CharField(max_length=6, validators=[MinLengthValidator(6)], primary_key=True)
    password = models.CharField(max_length=8, validators=[MinLengthValidator(8)])
    is_active = models.BooleanField(default = False)  
    def __str__(self):
        return self.username,self.email

class Show(models.Model):
    show_id = models.AutoField
    show_movie = models.ForeignKey('Movie', on_delete=models.CASCADE, default=None, related_name='show_movie')
    show_date = models.DateField()
    show_price = models.IntegerField()
    
    
    class TimeChoices(models.IntegerChoices):
        Nine = 9
        Eleven = 11
        Thirteen = 13
        Fifteen = 15
        Seventeen = 17
        Nineteen = 19

    show_time = models.IntegerField(choices=TimeChoices.choices)
    show_seats = models.IntegerField(default=80)
    show_booked_seats = models.IntegerField(default=0)
    
    def __str__(self):
        return str(self.show_movie) + ' | ' + str(self.show_date) + ' | ' + str(self.show_time)

class Booking(models.Model):
    booking_id = models.AutoField
    user = models.ForeignKey(Customer, on_delete=models.CASCADE)
    show = models.ForeignKey(Show, on_delete=models.CASCADE)
    number_of_tickets = models.IntegerField(validators=[MaxValueValidator(5)] )

    def __str__(self):
        return str(self.user) + ' | ' + str(self.show) + ' | ' + str(self.number_of_tickets)


class Reviews(models.Model):
   feedback_count = models.AutoField
   feedback_data = models.CharField(max_length=100  ,default="") 
   users =  models.ForeignKey(Customer, on_delete=models.CASCADE)
   disp_movie =  models.ForeignKey(Movie, on_delete=models.CASCADE)

   def __str__(self):
      return str(self.users) + ' | ' + str(self.feedback_data) + ' | ' + str(self. disp_movie)
