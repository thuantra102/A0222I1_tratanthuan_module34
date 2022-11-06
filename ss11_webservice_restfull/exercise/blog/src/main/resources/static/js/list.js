$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});
window.onload  = function () {
    const add = document.getElementById("addBtn");
    add.addEventListener("click", function () {
        document.getElementById("id").value = "";
        document.getElementById("name").value ="";
        document.getElementById("category").value = "";
        document.getElementById("content").value = "";
        document.getElementById("img").src = null;
    });
}


function save(id) {
    fetch("http://localhost:8080/" + id)
        .then(res => res.json())
        .then((data) => {
            document.getElementById("id").value = data.id;
            document.getElementById("name").value = data.name;
            document.getElementById("category").value = data.category.id;
            document.getElementById("content").value = data.content;
            document.getElementById("img").src = data.urlImage;

        })
};

function deleteId(id) {
   document.getElementById("deleteId").value = id;
}
function changeHref() {
    // alert("hello")
    // let href = document.getElementById("sort").href;
    // if(href === "sort?type=ASC") {
    //     document.getElementById("sort").href = "sort?type=DESC";
    // } else  {
    //     document.getElementById("sort").href = "sort?type=ASC";
    // }
}

