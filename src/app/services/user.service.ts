import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user.model";
import {Game} from "../models/game.model";

@Injectable({
	providedIn: 'root'
})
export class UserService implements OnInit {
	userURL: string = `http://localhost:3000/users`;
	gameURL: string = `http://localhost:3004/games`;

	constructor(private httpClient: HttpClient) {
		this.httpClient = httpClient;
	}

	ngOnInit(): void {
	}

	registerUser(user: User): Observable<User> {
		console.log("Working!!")
		return this.httpClient.post <User>(this.userURL, user);
	}

	loginUser(): Observable<User[]> {
		return this.httpClient.get<User[]>(this.userURL);
	}

	addGame(game: Game): Observable<Game> {
		return this.httpClient.post<Game>(this.gameURL, game);
	}

	getAllGames():Observable<Game[]>{
		return this.httpClient.get<Game[]>(this.gameURL);
	}

	deleteGame(id: number) {
			let URL = `${this.gameURL}/${id}`
			console.log(URL)
		 return this.httpClient.delete(this.gameURL +'/' +id)
	}

	getGameById(id: string){
		return this.httpClient.get<Game>(this.gameURL +'/' +id);
	}
	updateGame(id:string, game:Game){
		let URL = `${this.gameURL}/${id}`
		return this.httpClient.put<Game>(URL,game);
	}
}

