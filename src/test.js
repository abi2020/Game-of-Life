// function that builds a grid in the "container"
function createGrid(x) {
    //const container = document.getElementById("container");
    for (var rows = 0; rows < x; rows++) {
        for (var columns = 0; columns < x; columns++) {
            //container.append("<div class='grid'></div>");
            //let cell = $(document).createElement("div");
            //$("#container").appendChild(cell).classname = "grid";
            $("#container").append("<div class='grid'></div>");
        };
    };
    $(".grid").width(700/x);
    $(".grid").height(700/x);
};

// function that clears the grid
function clearGrid(){
    $(".grid").remove();
};

// function that prompts the user to select the number of boxes in a new grid
// the function then also creates that new grid
function refreshGrid(){
    var z = prompt("How many boxes per side?");
    clearGrid();
    createGrid(z);
};

// create a 16x16 grid when the page loads
// creates a hover effect that changes the color of a square to black when the mouse passes over it, leaving a (pixel) trail through the grid
// allows the click of a button to prompt the user to create a new grid
$(document).ready(function() {
    createGrid(20);

    /*
    $(".grid").mouseover(function() {
        $(this).css("background-color", "black");
        });
    */

    $(".grid").click(function() {
        $(this).css("background-color", "black");
        });
    /*
    var lebron = function() {
      $(this).css("background-color", "black");
      });
    }

    $(".grid").click(lebron).hover(lebron);



    var hoverOrClick = function () {
    // do something common
    $(this).css("background-color", "black");
    });
    }
    $(".grid").click(hoverOrClick).hover(hoverOrClick);
    */

    $(".newGrid").click(function() {
        refreshGrid();

        $(".grid").mouseover(function() {
        $(this).css("background-color", "black");
        });
    });
});
