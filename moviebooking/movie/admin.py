from django.contrib import admin
from .models import Movie, Customer, Genre, Show, Booking, Reviews

admin.site.register(Movie)
admin.site.register(Customer)
admin.site.register(Genre)
admin.site.register(Show)
admin.site.register(Booking)
admin.site.register(Reviews)
