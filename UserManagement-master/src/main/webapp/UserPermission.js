var addingCheckBoxes = ["dashboard_add", "user_info_add", "settings_add","w1_add","w2_add","w3_add"];
var deleteCheckBoxes = ["dashboard_delete", "user_info_delete", "settings_delete","w1_delete","w2_delete","w3_delete"];
var modifyCheckBoxes = ["dashboard_modify", "user_info_modify", "settings_modify","w1_modify","w2_modify","w3_modify"];
var readCheckBoxes = ["dashboard_read", "user_info_read", "settings_read","w1_read","w2_read","w3_read"];
var additionalPermissions = ['add','delete','modify','read'];
var adminPermissions = addingCheckBoxes.concat(deleteCheckBoxes,additionalPermissions,modifyCheckBoxes,readCheckBoxes);



var userAddingCheckBoxes = ["w1_add","w2_add","w3_add"];
var userModifyCheckBoxes = ["user_info_modify","w1_modify","w2_modify","w3_modify"];
var userReadCheckBoxes = ["w1_read","w2_read","w3_read"];
var userPermissions = userAddingCheckBoxes.concat(userModifyCheckBoxes,userReadCheckBoxes);
var userDashboardPermission=["dashboard_add","dashboard_delete","dashboard_modify","dashboard_read"]
var userInformationPermission=["user_info_add","user_info_delete", "user_info_modify","user_info_read"]
var userSettingPermission=["settings_add","settings_delete","settings_modify","settings_read"]
var userW1Permission=["w1_add","w1_delete","w1_modify","w1_read"]
var userW2Permission=["w2_add","w2_delete","w2_modify","w2_read"]
var userW3Permission=["w3_add","w3_delete","w3_modify","w3_read"]

function userRolePermissions(event) {
    var role = event.value;
    console.log(role, "role")
    if(role==1){
        for(i = 0; i < adminPermissions.length; i++) {
            checkBox = adminPermissions[i];
            document.getElementById(checkBox).checked = true;
        }
    }
    else if (role==0){
        for(i = 0; i < adminPermissions.length; i++) {
            checkBox = adminPermissions[i];
            document.getElementById(checkBox).checked = false;
        }
        for(i = 0; i < userPermissions.length; i++) {
            checkBox = userPermissions[i];
            document.getElementById(checkBox).checked = true;
        }
    }

}

        function onCheck(inputId) {
        var checkBoxId = document.getElementById(inputId);
            switch(inputId) {
                case "add":
                checkboxes = addingCheckBoxes;
                break;
                case "delete":
                checkboxes = deleteCheckBoxes;
                break;
                case "modify":
                checkboxes = modifyCheckBoxes;
                break;
                case "read":
                checkboxes = readCheckBoxes;
                break;
            }

            if (checkBoxId.checked == true){
                for(i = 0; i < checkboxes.length; i++) {
                    checkBox = checkboxes[i];
                    document.getElementById(checkBox).checked = true;
                }

            }


            else {
                for(i = 0; i < checkboxes.length; i++) {
                    checkBox = checkboxes[i];
                    document.getElementById(checkBox).checked = false;
                }
            }
        }


function isCheck(inputId) {
    switch(inputId) {
        case "addingCheckBoxes":
           var checkBoxes=addingCheckBoxes;
           value=0;
          find(checkBoxes,value);
            break;
        case "deleteCheckBoxes":
            var checkBoxes=deleteCheckBoxes;
            value=1;
            find(checkBoxes,value);
            break;
        case "modifyCheckBoxes":
            var checkBoxes=modifyCheckBoxes;
            value=2;
            find(checkBoxes,value);
            break;
        case "readCheckBoxes":
            var checkBoxes=readCheckBoxes;
            value=3;
            find(checkBoxes,value);
            break;
    }

}

function find(checkBoxes,value) {


    for (i = 0; i < checkBoxes.length; i++) {
        checkBox = checkBoxes[i];
        if (document.getElementById(checkBox).checked == false) {
            checkBox = additionalPermissions[value];
            document.getElementById(checkBox).checked = false;
        } else {
            check = 0;
            for (i = 0; i < checkBoxes.length; i++) {
                checkBox = checkBoxes[i];
                if (document.getElementById(checkBox).checked == false) {
                    checkBox = additionalPermissions[value];
                    document.getElementById(checkBox).checked = false;
                    check++;
                }

            }
            if (check == 0) {
                checkBox = additionalPermissions[value];
                document.getElementById(checkBox).checked = true;
            }
        }
    }
}