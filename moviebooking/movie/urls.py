from django.contrib import admin
from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from . import views 

urlpatterns = [
    path('', views.index, name='movieIndex'),
    path('login/', views.login, name='customerLogin'),
    path('signup/', views.signup, name='customerSignup'),
] 
#+ static(settings.STATIC_URL, documnet_root=settings.STATICFILES_DIRS)

admin.site.site_header = 'Movie Booking'
admin.site.site_title = 'Movie Booking'
admin.site.index_title = 'Welocome to the Admin page'
