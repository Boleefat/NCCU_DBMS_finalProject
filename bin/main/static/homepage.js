// Define the station names grouped by line


var searchInput = document.getElementById("searchInput");
var searchDropdown = document.getElementById("searchDropdown");

// Event listener to update dropdown when input changes
searchInput.addEventListener("input", function(event) {
    var searchValue = event.target.value.trim().toLowerCase();
    var filteredStations = [];

    // Filter stations based on input
    stationNames.forEach(function(line) {
        line.options.forEach(function(station) {
            if (station.toLowerCase().includes(searchValue)) {
                filteredStations.push({ label: line.label, value: station });
            }
        });
    });

    // Render dropdown
    renderDropdown(filteredStations);
});

// Function to render the dropdown
function renderDropdown(options) {
    // Clear previous dropdown
    searchDropdown.innerHTML = "";

    // Add options to dropdown
    options.forEach(function(option) {
        var item = document.createElement("div");
        item.textContent = option.label + " - " + option.value;
        item.classList.add("dropdown-item");
        searchDropdown.appendChild(item);
    });
}
// JavaScript to go back to initial homepage when the logo is clicked
document.querySelector(".logo").addEventListener("click", function() {
    window.location.href = "DBMS_Fontend.html";
});

// JavaScript to toggle search block visibility and update search input
document.getElementById("searchLink").addEventListener("click", function(event){
    event.preventDefault(); // Prevent default link behavior

    var searchBlock = document.getElementById("searchBlock");
    var reservationInfo = document.getElementById("reservationInfo");
    var hotelInfo = document.getElementById("hotelInfo");
    var more = document.getElementById("more");
    var dropdownMenu = document.querySelector(".dropdown-menu");

    if (searchBlock.classList.contains("open")) {
        searchBlock.classList.remove("open");
    } else {
        searchBlock.classList.add("open");
        reservationInfo.classList.remove("open"); // Ensure reservation block is closed
        hotelInfo.classList.remove("open"); // Ensure hotel info block is closed
        more.classList.remove("open"); // Close dropdown menu
        dropdownMenu.classList.remove("open"); // Close dropdown menu
    }
});

// JavaScript to toggle reservation info visibility
document.getElementById("reservationLink").addEventListener("click", function(event){
    event.preventDefault(); // Prevent default link behavior

    var searchBlock = document.getElementById("searchBlock");
    var reservationInfo = document.getElementById("reservationInfo");
    var hotelInfo = document.getElementById("hotelInfo");
    var more = document.getElementById("more");
    var dropdownMenu = document.querySelector(".dropdown-menu");

    if (reservationInfo.classList.contains("open")) {
        reservationInfo.classList.remove("open");
    } else {
        reservationInfo.classList.add("open");
        searchBlock.classList.remove("open"); // Ensure search block is closed
        hotelInfo.classList.remove("open"); // Ensure hotel info block is closed
        more.classList.remove("open"); // Close dropdown menu
        dropdownMenu.classList.remove("open"); // Close dropdown menu
    }
});

// JavaScript to toggle hotel info visibility
document.getElementById("hotelLink").addEventListener("click", function(event){
    event.preventDefault(); // Prevent default link behavior

    var searchBlock = document.getElementById("searchBlock");
    var reservationInfo = document.getElementById("reservationInfo");
    var hotelInfo = document.getElementById("hotelInfo");
    var more = document.getElementById("more");
    var dropdownMenu = document.querySelector(".dropdown-menu");

    if (hotelInfo.classList.contains("open")) {
        hotelInfo.classList.remove("open");
    } else {
        hotelInfo.classList.add("open");
        searchBlock.classList.remove("open"); // Ensure search block is closed
        reservationInfo.classList.remove("open"); // Ensure reservation block is closed
        more.classList.remove("open"); // Close dropdown menu
        dropdownMenu.classList.remove("open"); // Close dropdown menu
    }
});

// JavaScript to toggle dropdown menu visibility
document.getElementById("moreLink").addEventListener("click", function(event){
    event.preventDefault(); // Prevent default link behavior

    var searchBlock = document.getElementById("searchBlock");
    var reservationInfo = document.getElementById("reservationInfo");
    var hotelInfo = document.getElementById("hotelInfo");
    var more = document.getElementById("more");
    var dropdownMenu = document.querySelector(".dropdown-menu");

    if (more.classList.contains("open")) {
        more.classList.remove("open");
    } else {
        more.classList.add("open");
        searchBlock.classList.remove("open"); // Ensure search block is closed
        reservationInfo.classList.remove("open"); // Ensure reservation block is closed
        hotelInfo.classList.remove("open"); // Close hotel info block
        dropdownMenu.classList.remove("open"); // Close dropdown menu
    }
});



/*
//拖拉地圖
// Get the background image element
const backgroundImage = document.getElementById('bgImage');

// Get all the buttons
const buttons = document.querySelectorAll('.map-button');

// Initialize variables for tracking mouse movement
let isDragging = false;
let initialX = 0;
let initialY = 0;
let initialButtonPositions = {}; // Store initial positions of buttons

// Store initial positions of buttons
buttons.forEach(button => {
    // Get initial positions from CSS using window.getComputedStyle()
    const buttonStyles = window.getComputedStyle(button);
    const initialLeft = buttonStyles.getPropertyValue('left');
    const initialTop = buttonStyles.getPropertyValue('top');

    // Set initial positions obtained from CSS
    button.style.left = initialLeft;
    button.style.top = initialTop;

    initialButtonPositions[button.id] = {
        left: button.style.left, 
        top: button.style.top
    };
});

// Add event listeners for mouse down, move, and up events
backgroundImage.addEventListener('mousedown', function(event) {
  isDragging = true;
  initialX = event.clientX;
  initialY = event.clientY;
});

document.addEventListener('mousemove', function(event) {
  if (isDragging) {
    const movementX = event.clientX - initialX;
    const movementY = event.clientY - initialY;

    // Update background image position
    const currentPositionX = backgroundImage.style.backgroundPositionX ? parseInt(backgroundImage.style.backgroundPositionX) : 0;
    const currentPositionY = backgroundImage.style.backgroundPositionY ? parseInt(backgroundImage.style.backgroundPositionY) : 0;
    backgroundImage.style.backgroundPositionX = `${currentPositionX + movementX}px`;
    backgroundImage.style.backgroundPositionY = `${currentPositionY + movementY}px`;

    // Move all buttons in the same direction and distance as BR13
    buttons.forEach(button => {
      const initialButtonPosition = initialButtonPositions[button.id];
      button.style.left = `${initialButtonPosition.left + movementX}px`;
      button.style.top = `${initialButtonPosition.top + movementY}px`;
    });

    initialX = event.clientX;
    initialY = event.clientY;
  }
});
*/
// Get the background image element
const backgroundImage = document.getElementById('bgImage');
const button = document.getElementById('BR05');

// Get initial positions from CSS using window.getComputedStyle()
const buttonStyles = window.getComputedStyle(button);
const initialLeft = buttonStyles.getPropertyValue('left');
const initialTop = buttonStyles.getPropertyValue('top');

// Set initial positions obtained from CSS
button.style.left = initialLeft;
button.style.top = initialTop;

// Initialize variables for tracking mouse movement
let isDragging = false;
let initialX = 0;
let initialY = 0;

// Add event listeners for mouse down, move, and up events
backgroundImage.addEventListener('mousedown', function(event) {
  isDragging = true;
  initialX = event.clientX;
  initialY = event.clientY;
});

document.addEventListener('mousemove', function(event) {
  if (isDragging) {
    const movementX = event.clientX - initialX;
    const movementY = event.clientY - initialY;
    const currentPositionX = backgroundImage.style.backgroundPositionX ? parseInt(backgroundImage.style.backgroundPositionX) : 0;
    const currentPositionY = backgroundImage.style.backgroundPositionY ? parseInt(backgroundImage.style.backgroundPositionY) : 0;
    backgroundImage.style.backgroundPositionX = `${currentPositionX + movementX}px`;
    backgroundImage.style.backgroundPositionY = `${currentPositionY + movementY}px`;
    
    // Move button1 in the same direction and distance as the background image
    const currentButtonX = button.style.left ? parseInt(button.style.left) : 0;
    const currentButtonY = button.style.top ? parseInt(button.style.top) : 0;
    button.style.left = `${currentButtonX + movementX}px`;
    button.style.top = `${currentButtonY + movementY}px`;

    initialX = event.clientX;
    initialY = event.clientY;
  }
});




document.addEventListener('mouseup', function() {
  isDragging = false;
});




let zoomLevel = 1;

//滾輪 zoom in zoom out
// Add event listener for mouse wheel event
backgroundImage.addEventListener('wheel', function(event) {
    // Prevent default scroll behavior
    event.preventDefault();

    // Calculate zoom direction based on scroll direction
    const zoomDirection = event.deltaY > 0 ? -1 : 1;

    // Calculate new zoom level
    zoomLevel += zoomDirection * 0.1; // Adjust the zoom speed as needed

    // Limit zoom level to a minimum and maximum value if desired
    zoomLevel = Math.max(0.5, Math.min(3, zoomLevel)); // Example limits zoom level between 0.5x and 3x

    // Apply zoom level to background image
    backgroundImage.style.transform = `scale(${zoomLevel})`;
});

