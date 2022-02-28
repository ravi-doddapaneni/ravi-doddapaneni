package org.neobank.profile.repository;

import org.neobank.profile.entities.Address;
import org.neobank.profile.entities.Profile;
import org.springframework.stereotype.Repository;
import java.util.List;

import static org.neobank.profile.utils.Utility.parseDate;

@Repository
public
class ProfileApplicationRepository
{
    public List<Profile> getProfileDetails()
    {
        return List.of(
                new Profile("arauf",
                        "Atif",
                        "Rauf",
                        parseDate("1978-09-08"),
                        new Address("Verdun Tower",
                                "7775 King Fahd Rd",
                                "Riyadh",
                                "12212",
                                "Kingdom of Saudi Arabia")),
                new Profile("areza",
                        "Ali",
                        "Reza",
                        parseDate("1990-05-08"),
                        new Address("Prestige Center",
                                "Takhassusi Street",
                                "Riyadh",
                                "12331",
                                "Kingdom of Saudi Arabia"))
        );
    }
}
