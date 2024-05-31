
var VisibleMenu = ''; // 記錄目前顯示的子選單的 ID
function getvalue(inputId){ //get  value
var input = document.getElementById(inputId);
 if (input) {
    var str = input.value;
    onsole.log(str);
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
    var subMenu = document.getElementById('SubMenu1');
    if (subMenu.style.display === 'none') {
        subMenu.style.display = 'block';
    } else {
        subMenu.style.display = 'none';
    }
}


const en = {
    days: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
    daysShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
    daysMin: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
    months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
    monthsShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
    today: 'Today',
    clear: 'Clear',
    dateFormat: 'yyyy/MM/dd',
    timeFormat: 'hh:mm aa',
    firstDay: 0
};
const today = new Date(); // 獲取當前日期
const oneWeekLater = new Date(today.getTime() + 7 * 24 * 60 * 60 * 1000); // 獲取一星期後的日期

const datepicker = new AirDatepicker('#myDatepicker',{
    locale: en, // Set language
    minDate: today, // 設定最小日期為今天
    maxDate: oneWeekLater, // 設定最大日期為一星期後
});

// 定義 time 函數
function time(inputId1, inputId2) {
    var startStr = document.getElementById(inputId1).value;
    var endStr = document.getElementById(inputId2).value;

    // 將時間字符串轉換為 Date 物件，並設置相同的日期（例如 2000/01/01）
    var start = new Date("2000/01/01 " + startStr);
    var end = new Date("2000/01/01 " + endStr);

    if (start < end) {
       
    } else if (start > end) {
      
    } else {
     
    }
}
const confirmed = () => {
    Swal.fire({
        icon: 'success',
        title: 'RESERVATION CONFIRMED!',
        html: 'Your reservation no is!<br>Check your reservation status on RESERVATION Page.',
        
    }); 
}
const choosed = () => {
    Swal.fire({
        title: 'Deposit Or Delivery?',
        icon: 'info',
        showCancelButton: true,
        confirmButtonText: 'Deposit',
        cancelButtonText: 'Delivery',
      }).then((result) => {
        if (result.isConfirmed) {
          // 如果用戶點擊 "Deposit Page" 按鈕，執行相應的操作
          window.location.href = 'http://127.0.0.1:5500/DepositPage.html'; // 導向到 deposit page
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          // 如果用戶點擊 "Delivery" 按鈕，執行相應的操作
          window.location.href = 'http://127.0.0.1:5500/DeliveryPage.html'; // 導向到 delivery page
        }
      });
}


    $(document).ready(function() {
        // 初始化 start timepicker
        var start = $("#start").kendoTimePicker({
            change: startChange
        }).data("kendoTimePicker");
    
        // 初始化 end timepicker
        var end = $("#end").kendoTimePicker().data("kendoTimePicker");
    
        // 定義最小/最大範圍
        start.min("8:00 AM");
        start.max("6:00 PM");
    
        // 定義最小/最大範圍
        end.min("8:00 AM");
        end.max("7:30 AM");
    
        // start timepicker 改變事件處理函式
        function startChange() {
            var startTime = start.value(),
                endTime = end.value();
    
            if (startTime) {
                startTime = new Date(startTime);
                startTime.setMinutes(startTime.getMinutes() + 30);
                end.min(startTime);
            } else if (endTime) {
                start.max(new Date(endTime));
            } else {
                end.min("8:00 AM");
            }
        }
    });
    
