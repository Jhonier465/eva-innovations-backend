$(document).ready(function () {
    getAllAdmin();
   
});

function getAllAdmin() {
    $.ajax({
        url: "http://localhost:8080/api/Admin/all",
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            $("#resultsAdmin").empty();
            for (i = 0; i < p.length; i++) {
                let k = `
                <tr>
                    <td scope="row">${p[i].idAdmin}</td>
                    <td>${p[i].name}</td>
                    <td>${p[i].email}</td>
                    <td>${p[i].password}</td>
                    <td><input class="form-check-input me-1" type="radio" name="Admins" value="${p[i].idAdmin}" id="${p[i].idAdmin}" checked></td>
                </tr>      
                `;
                $("#resultsAdmin").append(k);
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
function getAdminData() {
    let admin = {
        name: $("#nameAdmin").val(),
        email : $("#emailAdmin").val(),
        password: $("#passwordAdmin").val()
    }
    return admin;
}
function cleanData() {
    $("#idAdmin").val("");
    $("#nameAdmin").val("");
    $("#emailAdmin").val("");
    $("#passwordAdmin").val("");

}
function saveAdmin() {

    let data = getAdminData();
    data.id = null;
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Admin/save",
        type: 'POST',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            getAllAdmin();
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
function getAdminById() {
    let idAdmin =$('input:radio[name=Admins]:checked').val(); 
    //$(".saveButtonJL").hide();
    //$(".updateButtonJL").show();
    $.ajax({
        url: "http://localhost:8080/api/Admin/" + idAdmin,
        type: 'GET',
        dataType: 'json',
        success: function (p) {
            $("#idAdmin").val(p.idAdmin);
            $("#nameAdmin").val(p.name);
            $("#emailAdmin").val(p.email);
            $("#passwordAdmin").val(p.password);
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        },
        complete: function (xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateAdmin() {
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function modifyDate(){
    $('#register').attr('disabled', true);
    $('#update').attr('disabled', false);
    getAdminById();

}
function updateAdmin() {
    let idAdmin =$('#idAdmin').val(); 
    let data = getAdminData();
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url: "http://localhost:8080/api/Admin/" + idAdmin,
        type: 'PUT',
        data: dataToSend,
        contentType: 'application/json',
        success: function (p) {
            cancelUpdateAdmin();
            getAllAdmin();
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

function deleteAdminById() {

    let idAdmin =$('input:radio[name=Admins]:checked').val();    
    $.ajax({
        url: "http://localhost:8080/api/Admin/" + idAdmin,
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
            getAllAdmin();
            cleanData();
        }
    });
   
    
}
