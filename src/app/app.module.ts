import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RegisterComponent } from './components/register/register.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import { LoginFormComponent } from './components/login-form/login-form.component';
import {HttpClientModule} from "@angular/common/http";
import { GameCreateComponent } from './components/game/game-create/game-create.component';
import { GameListComponent } from './components/game/game-list/game-list.component';
import {MatCardModule} from "@angular/material/card";
import { GameEditComponent } from './components/game/game-edit/game-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RegisterComponent,
    LoginFormComponent,
    GameCreateComponent,
    GameListComponent,
    GameEditComponent
  ],
	imports: [
		BrowserModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		MatToolbarModule,
		MatButtonModule,
		MatSidenavModule,
		MatIconModule,
		MatListModule,
		ReactiveFormsModule,
		MatInputModule,
		FormsModule,
		HttpClientModule,
		MatCardModule,
	],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
