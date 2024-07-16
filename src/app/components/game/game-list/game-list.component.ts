import {Component, OnInit} from '@angular/core';
import {Game} from "../../../models/game.model";
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";

@Component({
	selector: 'app-game-list', templateUrl: './game-list.component.html', styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {
	gameList: Game[] = []

	constructor(private userService: UserService, private router: Router) {
		this.userService = userService;
	}
	ngOnInit(): void {
		this.userService.getAllGames().subscribe(games => {
			this.gameList = games
		})
	}
	add() {
		this.router.navigate(['game-create'])
	}

	delete(id: number) {
		console.log(id)
		this.userService.deleteGame(id).subscribe(response => {
			alert("Deleted Successfully")
			window.location.reload()
		})
	}

	edit(id:number) {
		this.router.navigate(['game-edit/'+id])
	}
}
