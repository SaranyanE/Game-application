import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
	selector: 'app-game-edit',
	templateUrl: './game-edit.component.html',
	styleUrls: ['./game-edit.component.css']
})
export class GameEditComponent implements OnInit {
	editGameForm!: FormGroup;
	id: string = ''

	constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router, private userService: UserService) {
		this.userService = userService;
	}

	ngOnInit(): void {
		this.route.params.subscribe((params) => {
			if (params['id']) {
				this.id = params['id']
				this.userService.getGameById(this.id).subscribe(game => {
					if (game) {
						console.log(game.title)
						this.editGameForm = this.formBuilder.group({
							id: [game.id],
							title: [game.title],
							genre: [game.genre],
							releaseYear: [game.releaseYear],
							rating: [game.rating]
						})
					}
				})
			}
		})
	}

	updateGame() {
		console.log(this.editGameForm.value)
		this.userService.updateGame(this.id, this.editGameForm.value)
			.subscribe(response => {
				alert("Game Registered Successfully");
				this.editGameForm.reset();
				this.router.navigate(['game-list'])
			}, error => {
				alert("Something went Wrong");
			})
	}
}

