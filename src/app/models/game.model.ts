export class Game {
	id: number
	title: string
	genre: string
	releaseYear: string
	rating: string

	constructor(id: number, title: string, genre: string, releaseYear: string, rating: string) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}
}
