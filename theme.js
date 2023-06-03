
    function showOptions() {
    var options = document.getElementById("options");
    if (options.style.display === "none") {
      options.style.display = "block";
    } else {
      options.style.display = "none";
    }
    }
  function changecss(){
  var css1 = document.getElementById("css1");
  var css2 = document.getElementById("css2");
  var Select = document.getElementById("theme");
  var selectedTheme = Select.value;

  if (selectedTheme==="light"){
    css1.href = "../../m-world light.css";
  }
  else if(selectedTheme==="dark"){
    css1.href = "../../m-world.css";
  }
  if (selectedTheme==="light"){
    css2.href = "../../m-world.css";
  }
  else if(selectedTheme==="dark"){
    css2.href = "../../m-world light.css";
  }
}