
(function () {

var $removeBtn, $editBtn, $createBtn;
var userService = new AdminUserServiceClient();

var selectedUser = null;

var users = [];

function clearForm() {
    $userNameFld.val("");
    $passwordFld.val("");
    $firstNameFld.val("");
    $lastNameFld.val("");
    $roleFld.prop('selectedIndex',0);
}


function createUser(user) {

    userService.createUser(user)
        .then (function (actualUser) {
            users.push(actualUser)
            renderUsers(users)

        })

}

function deleteUser(event) {

    var deleteTask = jQuery(event.target);
    var theIndex = deleteTask.attr("id");
    var theId = users[theIndex]._id;


    userService.deleteUser(theId)
            .then (function (status) {
                users.splice(theIndex, 1)
                renderUsers(users)

            })

}
function selectUser(event) {

    var editTask = jQuery(event.target);
    var theIndex = editTask.attr("id");
    selectedUser = users.find(user => user._id === theIndex)

    $userNameFld.val(selectedUser.username);
    $passwordFld.val(selectedUser.password);
    $firstNameFld.val(selectedUser.firstname);
    $lastNameFld.val(selectedUser.lastname);
    $roleFld.val(selectedUser.role);


}

function updateUser() {

    selectedUser.username = $userNameFld.val();
    selectedUser.password = $passwordFld.val();
    selectedUser.firstname = $firstNameFld.val();
    selectedUser.lastname = $lastNameFld.val();
    selectedUser.role = $roleFld.val();

    userService.updateUser(selectedUser._id, selectedUser)
    .then (function(status) {
         var index = users.findIndex(user => user._id === selectedUser._id)
         users[index] = selectedUser
         renderUsers(users)
    })

    // WILL remove the filled values afterwards
        clearForm();
}

function renderUsers(users) {

    theTableBody.empty();

    for(var i = 0; i < users.length; i++) {
        var user = users[i]
        //Need to append instead of prepend to maintain the order of entries
        theTableBody.append(`
                <tr class="wbdv-template wbdv-user wbdv-hidden">
                    <td class="wbdv-username wbdv-align-center">${user.username}</td>
                    <td>&nbsp;</td>
                    <td class="wbdv-first-name wbdv-align-center">${user.firstname}</td>
                    <td class="wbdv-last-name wbdv-align-center">${user.lastname}</td>
                    <td class="wbdv-role wbdv-align-center">${user.role}</td>
                    <td class="wbdv-align wbdv-actions">
                        <span class="pull-right">

                            <button id="${i}" title="DELETE">
                                <i class="fa-2x fa fa-times wbdv-remove" id="${i}"></i>
                            </button>

                            <button title="EDIT">
                                <i class="fa-2x fa fa-pencil wbdv-edit" id="${user._id}"></i>
                            </button>
                        </span>
                    </td>
                </tr>
        `)
    }

    jQuery(".wbdv-remove")
        .click(deleteUser)

    jQuery(".wbdv-edit")
        .click(selectUser)



}

function findAllUsers() { } // optional - might not need this
function findUserById() { } // optional - might not need this



function main() {

    $userNameFld = $(".wbdv-username-fld");
    $passwordFld = $(".wbdv-password-fld");
    $firstNameFld = $(".wbdv-firstname-fld");
    $lastNameFld = $(".wbdv-lastname-fld");
    $roleFld = $(".wbdv-role-fld");

    $createBtn = $(".wbdv-create-user");

    $removeBtn = $(".wbdv-remove")

    $updateBtn = $(".wbdv-update");

    theTableBody = jQuery("tbody")



    $createBtn.click(() => {

        createUser({
            username: $userNameFld.val(),
            password: $passwordFld.val(),
            firstname: $firstNameFld.val(),
            lastname: $lastNameFld.val(),
            role: $roleFld.val()

        })

        // WILL remove the filled values afterwards
        clearForm();


    })

    $updateBtn.click(updateUser);


    userService.findAllUsers()
        .then(function (actualUsersFromServer) {
          users = actualUsersFromServer
          renderUsers(users)
        })

}

jQuery(main)

})();
