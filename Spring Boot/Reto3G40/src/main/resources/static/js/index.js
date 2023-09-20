$(document).ready(function () {
    getAllCategory();
});

function getAllCategory() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            console.log(p);
            $("#resultsCategory").empty();
            for (i = 0; i < p.length; i++) {
                let k = `
                            <tr>
                                <th scope="row">${p[i].id}</th>
                                <td>${p[i].name}</td>
                                <td>${p[i].description}</td>

                            </tr>       
                        `;
                $("#resultsCategory").append(k);
            }
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
              //alert('Petición realizada');
        }
    });
}
function getCategoryData() {
    let cat = {
        name: $("#inputName").val(),
        description: $("#inputDescription").val()
    }
    return cat;
}
function cleanData() {
    $("#inputIdCat").val("");
    $("#inputName").val("");
    $("#inputDescription").val("");
}
function saveCategory() {

    let data = getCategoryData();
    data.id = null;
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Category/save",
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            console.log(p);
            cleanData();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getCategoryById() {
    let idCat = $("#inputIdCat").val();
    //$(".saveButtonJL").hide();
    //$(".updateButtonJL").show();
    $.ajax({
        url: "http://localhost:8080/api/Category/" + idCat,
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            console.log(p);
            $("#inputId").val(p.id);
            $("#inputName").val(p.name);
            $("#inputDescription").val(p.description);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateCategory() {
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function updateCategory() {
    let idCat = $("#inputIdCat").val();
    let data = getCategoryData();
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Category/"+idCat,
        type: 'PUT',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            console.log(p);
            cancelUpdateCategory();
            getAllCategory();

        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function deleteCategoryById() {
    let idCat= $("#inputIdCat").val();
    $.ajax({
        url: "http://localhost:8080/api/Category/" + idCat,
        type: 'DELETE',
        dataType: 'json',
        success: function (p) {
            console.log(p);
            cleanData();
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}