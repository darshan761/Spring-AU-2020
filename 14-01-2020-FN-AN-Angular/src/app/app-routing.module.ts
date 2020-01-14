import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FormComponent } from './components/form/form.component';
import {DisplayComponent} from './components/display/display.component';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component'


const routes: Routes = [
  {path:'',redirectTo:'/form',pathMatch:'full'},
  {path:'form', component:FormComponent},
  {path:'display', component:DisplayComponent},
  {path:'**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
