from django import forms
from .models import Customer
from django.core.validators import MinLengthValidator
from django.utils.translation import ugettext_lazy as _


class CustomerSignupForm(forms.Form):
    password1 = forms.CharField(max_length=8, validators=[MinLengthValidator(8)])

    class Meta:
        model = Customer
        fields = ['username', 'email', 'password', 'password1']
    
    def validate(self):
        super(CustomerSignupForm, self).clean()
        if len(self.cleaned_data.get['username'] )!=6:
            raise ValueError(_('username should have 6 characters only!!'))
        if self.cleaned_data.get['password'] != self.cleaned_data.get['password1']:
            raise ValueError(_('Passwords not matching'))

            