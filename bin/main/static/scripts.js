
    
    var VisibleMenu = ''; // 記錄目前顯示的子選單的 ID
    function getvalue(inputId){ //get  value
        var input = document.getElementById(inputId);
        if (input) {
        var str = input.value;
        console.log(str);
    }
    }
    function getpass(inputId){ //get password value
        var input = document.getElementById(inputId);
        if (input) {
        var str = input.value;
        console.log(str);
    }
    }
   

// 顯示或隱藏子選單
function switchMenu(theMainMenu, theSubMenu, theEvent) {
    var SubMenu = document.getElementById(theSubMenu);
    if (SubMenu.style.display == 'none') { // 顯示子選單
        SubMenu.style.minWidth = theMainMenu.clientWidth; // 讓子選單的最小寬度與主選單相同 (僅為了美觀)
        SubMenu.style.display = 'block';
        hideMenu(); // 隱藏其他子選單
        VisibleMenu = theSubMenu;
    } else { // 隱藏子選單
        if (theEvent != 'MouseOver' || VisibleMenu != theSubMenu) {
            SubMenu.style.display = 'none';
            VisibleMenu = '';
        } else { // 隱藏子選單，因爲按鈕已被再次點擊
            SubMenu.style.display = 'none';
            VisibleMenu = '';
        }
    }
}
console.log("hiiii");
