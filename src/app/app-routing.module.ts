import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from "./components/register/register.component";
import {LoginFormComponent} from "./components/login-form/login-form.component";
import {GameCreateComponent} from "./components/game/game-create/game-create.component";
import {GameListComponent} from "./components/game/game-list/game-list.component";
import {GameEditComponent} from "./components/game/game-edit/game-edit.component";

const routes: Routes = [
	{
		path:'',redirectTo:'login',pathMatch:"full"
	},
	{
		path:'register',component:RegisterComponent
	},
	{
		path:'login',component:LoginFormComponent
	},
	{
		path:'game-create',component:GameCreateComponent
	},
	{
		path:'game-list',component:GameListComponent
	},
	{
		path:'game-edit/:id',component:GameEditComponent
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
