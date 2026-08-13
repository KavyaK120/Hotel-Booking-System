document.addEventListener("DOMContentLoaded", loadHotels);

async function loadHotels() {

    try {

        const response = await fetch("http://localhost:8082/api/hotels");

        if (!response.ok) {
            throw new Error("Failed to load hotels");
        }

        const hotels = await response.json();

        displayHotels(hotels);

    } catch (error) {

        console.error("Error loading hotels:", error);

        document.getElementById("hotelContainer").innerHTML =
            "<p>Unable to load hotels.</p>";
    }
}


function displayHotels(hotels) {

    const hotelContainer =
        document.getElementById("hotelContainer");

    hotelContainer.innerHTML = "";

    hotels.forEach(hotel => {

        const hotelCard = document.createElement("div");

        hotelCard.className = "hotel-card";

        hotelCard.innerHTML = `
            
            <img src="../images/${hotel.image}" 
                 alt="${hotel.name}">

            <div class="hotel-info">

                <h3>${hotel.name}</h3>

                <p>📍 ${hotel.location}</p>

                <p>⭐ ${hotel.rating}</p>

                <p>${hotel.description}</p>

                <h4>₹${hotel.pricePerNight} / night</h4>

                <button onclick="viewHotel(${hotel.id})">
                    View Details
                </button>

            </div>
        `;

        hotelContainer.appendChild(hotelCard);

    });
}


function viewHotel(id) {

    window.location.href =
        `hotel-details.html?id=${id}`;

}