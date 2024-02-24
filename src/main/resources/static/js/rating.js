
    document.addEventListener("DOMContentLoaded", function() {
        const stars = document.querySelectorAll('.rating input[type="radio"]');
        stars.forEach(star => {
            star.addEventListener("change", function() {
                const selectedRating = this.value;
                const selectedStar = this.id;
                const labels = document.querySelectorAll('.rating label');
                labels.forEach(label => {
                    if (label.htmlFor <= selectedStar) {
                        label.style.color = "gold";
                    } else {
                        label.style.color = "#ccc";
                    }
                });
            });
        });
    });