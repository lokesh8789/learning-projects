import { Component, signal, effect } from '@angular/core';
import { email, form, FormField, FormRoot, minLength, required, submit } from '@angular/forms/signals';
import { sleep, countryList, stateList } from '../../utils/app.util';
import { createInitialLoginForm, LoginModel } from '../../models/login';

@Component({
  imports: [FormField, FormRoot],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {
  countryList: string[] = countryList;
  stateList: Record<string, string[]> = stateList;

  formModel = signal<LoginModel>(createInitialLoginForm());

  loginForm = form(this.formModel, (path) => {
    minLength(path.password, 6);
    email(path.email);
    required(path.email, { message: "Email is required" });
    required(path.password);
    required(path.country);
    required(path.state);
  }, {
    submission: {
      action: async (form) => {
        await sleep(2000)
        console.log(this.formModel());
        form().reset(createInitialLoginForm())
      }
    }
  });

  eff = effect(() => {
    this.loginForm.country().value();
    this.loginForm.state().reset('')
  });

  onSave(event: SubmitEvent) {
    event.preventDefault();
    submit(this.loginForm, async () => {
      console.log(this.formModel())
    })
  }
}
