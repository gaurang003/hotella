"use strict";
document.addEventListener("DOMContentLoaded", function() {
    const navOptions = document.querySelectorAll('.nav-option');

    // Function to handle click on navigation options
    function handleNavigationClick(event) {
        // Prevent the default anchor click behavior
        event.preventDefault();

        // Get the URL from the anchor tag
        const url = this.querySelector('a').getAttribute('href');

        // Redirect to the respective page
        window.location.href = url;

        // Remove 'selected' class from all options
        navOptions.forEach(opt => opt.classList.remove('selected'));
        // Add 'selected' class to the clicked option
        this.classList.add('selected');
    }

    // Add click event listeners to navigation options
    navOptions.forEach(option => {
        option.addEventListener('click', handleNavigationClick);
    });
});
