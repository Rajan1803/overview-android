package com.simform.glimpses.model

data class Location(val name: String, val businessName: String) {

    companion object {
        var locations = arrayListOf<Location>(
            Location(name = "Ahmedabad", businessName = "Simform"),
            Location(name = "Ahmedabad", businessName = "Simform"),
            Location(name = "Banglore", businessName = "Facebook"),
            Location(name = "Agartala", businessName = "Instagram"),
            Location(name = "Agra", businessName = "Tata"),
            Location(name = "Zanskar", businessName = "Reliance"),
            Location(name = "Varanasi", businessName = "Jio"),
            Location(name = "Vaishali", businessName = "ICC"),
            Location(name = "Ujjain", businessName = "Sony"),
            Location(name = "Udaipur", businessName = "Samsung"),
            Location(name = "Trichy", businessName = "Apple"),
            Location(name = "Tirupati", businessName = "Google"),
            Location(name = "Tirunelveli", businessName = "Firefox"),
            Location(name = "Thrissur", businessName = "Ford"),
            Location(name = "Thiruvananthapuram", businessName = "Walmart"),
            Location(name = "Varanasi", businessName = "Saudi Aramco"),
            Location(name = "Tezpur", businessName = "Simform")
        )
    }

}