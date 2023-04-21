const apiKey = "5ce0addb";
const apiUrl = "https://www.omdbapi.com/?apikey=" + apiKey + "&";
const headerImg = document.getElementById("header-img");
const headerTitle = document.getElementById("header-title");
const headerPlot = document.getElementById("header-plot");
const contentCards = document.getElementById("content-cards");
const movieLink = document.getElementById("movie-link");
const seriesLink = document.getElementById("series-link");
const animeLink = document.getElementById("anime-link");
const prev = document.getElementById("prev");
const next = document.getElementById("next");
const search = document.getElementById("search-icon");
const searchInput = document.getElementById("search-input");

let currentPage = 1;
let currentType = "movie";
let currentSearch;
getCurrentSearch();


console.log(currentSearch);

function fetchContent(page) {
  fetch(`${apiUrl}s=${currentSearch}&type=${currentType}&page=${page}`)
    .then(response => response.json())
    .then(data => {
      displayHeader(data.Search[0]);
      displayContent(data.Search.slice(1));
    })
    .catch(error => console.error(error));
}

function displayHeader(movie) {
  headerImg.src = movie.Poster;
  headerTitle.textContent = movie.Title;
  fetch(`${apiUrl}i=${movie.imdbID}&plot=full`)
    .then(response => response.json())
    .then(data => {
      headerPlot.textContent = data.Plot;
    })
    .catch(error => console.error(error));
}

function displayContent(movies) {
  contentCards.innerHTML = "";
  movies.forEach(movie => {
    const card = document.createElement("div");
    card.classList.add("card");
    card.innerHTML = `
      <img src="${movie.Poster}" alt="${movie.Title}">
      <div class="card-info">
        <h2>${movie.Title}</h2>
        <p>${movie.Year}</p>
      </div>
    `;
    contentCards.appendChild(card);
  });
}

function getCurrentSearch() {
  if (localStorage.getItem("currentSearch")) {
    currentSearch = localStorage.getItem("currentSearch");
  } else {
    currentSearch = "Matrix";
    localStorage.setItem("currentSearch", currentSearch);
  }
}

movieLink.addEventListener("click", () => {
  currentType = "movie";
  currentPage = 1;
  fetchContent(currentPage);
});

seriesLink.addEventListener("click", () => {
  currentType = "series";
  currentPage = 1;
  fetchContent(currentPage);
});

animeLink.addEventListener("click", () => {
  currentType = "series";
  currentPage = 1;
  fetchContent(currentPage);
});

prev.addEventListener("click", () => {
  if (currentPage > 1) {
    currentPage--;
    fetchContent(currentPage);
  }
});

next.addEventListener("click", () => {
  currentPage++;
  fetchContent(currentPage);
});

fetchContent(currentPage);

search.addEventListener("click", () => {
  searchInput.classList.toggle("active");
});

searchInput.addEventListener("keyup", e => {
  if (e.key === "Enter") {
    localStorage.setItem("currentSearch", searchInput.value);
    currentSearch = localStorage.getItem("currentSearch");
    fetchContent(currentPage);
  }
});