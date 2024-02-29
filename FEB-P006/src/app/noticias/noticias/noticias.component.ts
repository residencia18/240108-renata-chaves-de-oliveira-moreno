import { Component, OnInit } from '@angular/core';
import axios from 'axios';

interface ISource {
  id: number | null;
  name: string;
}

interface INews {
  author: string;
  content: string;
  description: string;
  publishedAt: string;
  source: ISource;
  title: string;
  url: string;
  urlToImage: string;
}

@Component({
  selector: 'app.noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.scss']
})
export class NewsComponent implements OnInit {
  // Correção: Definindo o tipo do array como Array<INews>
  news: Array<INews> = [];

  ngOnInit() {
    this.logIt();
  }

  logIt() {
    axios.get("https://newsapi.org/v2/everything?q=science&apiKey=67be9d1df077449ba24c6070e7804af8&language=pt").then((res) => {

      res.data.articles.forEach((element: INews, index: number) => {
        if (element.title === "[Removed]") {
          res.data.articles.splice(index, 1);
        }
      });

      return res.data;
    }).then((data) => {
      console.log(data.articles);
      this.news = [...data.articles.slice(0, 5)];
      console.log(this.news);
    });
  }
}
