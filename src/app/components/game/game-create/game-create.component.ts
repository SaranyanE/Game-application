import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-game-create',
  templateUrl: './game-create.component.html',
  styleUrls: ['./game-create.component.css']
})
export class GameCreateComponent {
	createGameForm!: FormGroup;

	constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) {
		this.userService = userService;
	}

	ngOnInit() {
		this.createGameForm = this.formBuilder.group({
			title: ['',Validators.required],
			genre: ['',Validators.required],
			releaseYear: ['',Validators.required],
			rating: ['',Validators.required],
		})
	}
	addGame() {
		console.log(this.createGameForm.value)
		 this.userService.addGame(this.createGameForm.value)
			.subscribe(response => {
				alert("Game Registered Successfully");
				this.createGameForm.reset();
				this.router.navigate(['game-list'])
			}, error => {
				alert("Something went Wrong");
			})
	}
}
