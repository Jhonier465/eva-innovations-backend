$(document).ready(function () {
    getAllClient();
   
});

function getAllClient() {
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            $("#resultsClient").empty();
            for (i = 0; i < p.length; i++) {
                let k = `
                <tr>
                    <td scope="row">${p[i].idClient}</td>
                    <td>${p[i].name}</td>
                    <td>${p[i].age}</td>
                    <td>${p[i].email}</td>
                    <td>${p[i].password}</td>
                    <td><input class="form-check-input me-1" type="radio" name="clients" value="${p[i].idClient}" id="${p[i].idClient}" checked></td>
                </tr>      
                `;
                $("#resultsClient").append(k);
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
function getClientData() {
    let client = {
        name: $("#nameClient").val(),
        age : $("#ageClient").val(),
        email : $("#emailClient").val(),
        password: $("#passwordClient").val()
    }
    return client;
}
function cleanData() {
    $("#idClient").val("");
    $("#nameClient").val("");
    $("#ageClient").val("");
    $("#emailClient").val("");
    $("#passwordClient").val("");

}
function saveClient() {

    let data = getClientData();
    data.id = null;
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Client/save",
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            getAllClient();
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
function getClientById() {
    let idClient =$('input:radio[name=clients]:checked').val(); 
    //$(".saveButtonJL").hide();
    //$(".updateButtonJL").show();
    $.ajax({
        url: "http://localhost:8080/api/Client/" + idClient,
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            $("#idClient").val(p.idClient);
            $("#nameClient").val(p.name);
            $("#ageClient").val(p.age);
            $("#emailClient").val(p.email);
            $("#passwordClient").val(p.password);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateClient() {
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function modifyDate(){
    $('#register').attr('disabled', true);
    $('#update').attr('disabled', false);
    getClientById();

}
function updateClient() {
    let idClient =$('#idClient').val(); 
    let data = getClientData();
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Client/" + idClient,
        type: 'PUT',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            cancelUpdateClient();
            getAllClient();
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

function deleteClientById() {

    let idClient =$('input:radio[name=clients]:checked').val();    
    $.ajax({
        url: "http://localhost:8080/api/Client/" + idClient,
        type: 'DELETE',
        dataType: 'json',
        success: function (p) {
            
           // getAllClient();
        },
        error: function (xhr, status) {
           // alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
            getAllClient();
            cleanData();
        }
    });
   
    
}
