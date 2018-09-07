import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login_screen/login.component';
import {LoginScreenComponent} from './login_screen/login_screen.component';
import {AuthGuard} from './_guards/auth.guard';
import {TaskComponent} from './tasks/task.component';
import {RegisterComponent} from './register/register.component';

const appRoutes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full',  canActivate: [AuthGuard] },
  {path: 'home', component: HomeComponent },
  {path: 'login',  component: LoginComponent,
    children: [
      {path: '', component: LoginScreenComponent}]
  },
  // {path: 'tasks', component: TaskComponent},
  {path: 'register', component: RegisterComponent },
  // otherwise redirect to home
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]

})
export class AppRoutingModule {}
