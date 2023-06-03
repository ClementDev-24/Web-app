function changePage() {
    const selectBox = document.getElementById("pageSelect");
    const selectedValue = selectBox.options[selectBox.selectedIndex].value;
    if (selectedValue=="English") {
      window.location.href = "../../movies/English/ENGLISH MOVIE.html";
    }
    else if (selectedValue=="Malayalam") {
        window.location.href = "../../movies/malayalam/Malayalam movies.html";
      }
      else if (selectedValue=="Malayalam") {
        window.location.href = "../../movies/malayalam/Malayalam movies.html";
      }
      else if (selectedValue=="Tamil") {
        window.location.href = "../../movies/TAMIL MOVIES.html";
      }
      else if (selectedValue=="Telugu") {
        window.location.href = "../../movies/Telugu/Telegu movie.html";
      }
  }