import axios from "axios";

function fetchMovies() {
  axios.get("https://www.omdbapi.com/?apikey=7035c60c&s=frozen").then((res) => {
    console.log(res);
    const h1El = document.querySelector("h1");
    const imgEl = document.querySelector("img");
    const classDecription = document.querySelector(".decription");

    h1El.textContent = res.data.Search[0].Title;
    imgEl.src = res.data.Search[0].Poster;
    classDecription.textContent = res.data.Search[0].Year;
  });
}

fetchMovies();
