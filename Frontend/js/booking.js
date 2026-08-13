document.addEventListener("DOMContentLoaded", loadBooking);

function loadBooking() {

    const booking = JSON.parse(localStorage.getItem("booking"));

    const bookingContainer = document.getElementById("bookingList");

    if (!booking) {

        bookingContainer.innerHTML =
            "<p>No booking found.</p>";

        return;
    }

    bookingContainer.innerHTML = `

        <div class="booking-summary">

            <h2>Booking Summary</h2>

            <p>
                <strong>Hotel:</strong>
                ${booking.hotelName}
            </p>

            <p>
                <strong>Room:</strong>
                ${booking.roomType}
            </p>

            <p>
                <strong>Check In:</strong>
                ${booking.checkIn}
            </p>

            <p>
                <strong>Check Out:</strong>
                ${booking.checkOut}
            </p>

            <p>
                <strong>Guests:</strong>
                ${booking.guests}
            </p>

            <p>
                <strong>Price:</strong>
                ₹${booking.price}
            </p>

            <button onclick="confirmBooking()">
                Confirm Booking
            </button>

        </div>

    `;
}


async function confirmBooking() {

    const booking = JSON.parse(localStorage.getItem("booking"));

    const user = JSON.parse(localStorage.getItem("user"));

    if (!booking) {

        alert("No booking details found.");

        return;
    }

    if (!user) {

        alert("Please login first.");

        window.location.href = "login.html";

        return;
    }


    const bookingData = {

        checkInDate: booking.checkIn,

        checkOutDate: booking.checkOut,

        numberOfGuests: Number(booking.guests),

        totalAmount: Number(booking.price),

        bookingStatus: "CONFIRMED",

        hotel: {
            id: Number(booking.hotelId)
        },

        user: {
            id: Number(user.id)
        }

    };


    try {

        const response = await fetch(
            "http://localhost:8082/api/bookings",
            {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(bookingData)

            }
        );


        if (!response.ok) {

            const errorText = await response.text();

            console.error(errorText);

            throw new Error("Booking failed");

        }


        const result = await response.json();

        console.log("Booking saved:", result);


        alert("Booking confirmed successfully!");


        localStorage.removeItem("booking");


        window.location.href = "my-bookings.html";


    } catch (error) {

        console.error("Booking error:", error);

        alert("Unable to confirm booking.");

    }

}