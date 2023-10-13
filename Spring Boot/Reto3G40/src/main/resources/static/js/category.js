$(document).ready(function () {
    getAllCategory();
   
});

function getAllCategory() {
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            $("#resultsCategory").empty();
            for (i = 0; i < p.length; i++) {
                let k = `
                <tr>
                    <td scope="row">${p[i].id}</td>
                    <td>${p[i].name}</td>
                    <td>${p[i].description}</td>
                    <td><input class="form-check-input me-1" type="radio" name="categories" value="${p[i].id}" id="${p[i].id}" checked></td>
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
    let category = {
        name: $("#nameCategory").val(),
        description : $("#descriptionCategory").val(),
    }
    return category;
}
function cleanData() {
    $("#idCategory").val("");
    $("#nameCategory").val("");
    $("#descriptionCategory").val("");
    

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
            getAllCategory();
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
    let idCategory =$('input:radio[name=categories]:checked').val(); 
    //$(".saveButtonJL").hide();
    //$(".updateButtonJL").show();
    $.ajax({
        url: "http://localhost:8080/api/Category/" + idCategory,
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            $("#idCategory").val(p.id);
            $("#nameCategory").val(p.name);
            $("#descriptionCategory").val(p.description);
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
function modifyDate(){
    $('#register').attr('disabled', true);
    $('#update').attr('disabled', false);
    getCategoryById();

}
function updateCategory() {
    let idCategory =$('#idCategory').val(); 
    let data = getCategoryData();
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Category/" + idCategory,
        type: 'PUT',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            cancelUpdateCategory();
            getAllCategory();
            $('#register').attr('disabled', false);
            $('#update').attr('disabled', true);


        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
    
}

function deleteCategoryById() {

    let idCategory =$('input:radio[name=categories]:checked').val();    
    $.ajax({
        url: "http://localhost:8080/api/Category/" + idCategory,
        type: 'DELETE',
        dataType: 'json',
        success: function (p) {
            
           // getAllCategory();
        },
        error: function (xhr, status) {
           // alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
            getAllCategory();   
            cleanData();
        }
    });
   
    
}
