@file:Suppress("DEPRECATION")
package cmp2804.tse.server.data

import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import java.sql.Date


/**
 * Example data for Users
 *
 * This data is used for testing and examination purposes.
 *
 * In a live example, this data would not be included
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */

val USER_BARRY = User(
    null,
    "barry_johnson",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Barry",
    "Johnson",
    Date(1962, 4, 23),
    SexEnum.MALE,
    mutableListOf("they/them"),
    "barry62@geezermail.com",
    "07000000000",
    51.41142516664304,
    -0.30055887976455625,
    null,
    "Sandra",
    mutableSetOf(RolesEnum.PATIENT),
)
val USER_VINCENT = User(
    null,
    "vincent",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Vincent",
    "van Gogh",
    Date(1853, 3, 30),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "vincent@gmail.com",
    "07000000001",
    51.470009190766746,
    4.661027886598867,
    null,
    "Amy Pond",
    mutableSetOf(RolesEnum.PATIENT),
)

// DOCTORS

val USER_CHARLIE = User(
    null,
    "thomas",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Thomas",
    "Higgins",
    Date(2000, 11, 30),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "thomas@gmail.com",
    "07000000003",
    53.22994562194274,
    -0.5476375217330632,
    null,
    "Johnny",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_OLIVIA = User(
    null,
    "olivia-smith",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Olivia",
    "Smith",
    Date(1995, 3, 15),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "olivia_smith@gmail.com",
    "07000000004",
    53.4502932819472,
    -0.11234567123456,
    null,
    "David Johnson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_JACK = User(
    null,
    "jack-brown",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Jack",
    "Brown",
    Date(1988, 7, 24),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "jack_brown@gmail.com",
    "07000000005",
    52.7603821928473,
    -0.22345678234567,
    null,
    "Emma Wilson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_AMELIA = User(
    null,
    "amelia-jones",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Amelia",
    "Jones",
    Date(1991, 12, 5),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "amelia_jones@gmail.com",
    "07000000006",
    51.8904732918473,
    -0.33456789345678,
    null,
    "Michael Brown",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_GEORGE = User(
    null,
    "george-taylor",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "George",
    "Taylor",
    Date(1985, 9, 13),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "george_taylor@gmail.com",
    "07000000007",
    53.7810928347591,
    -0.44567893456789,
    null,
    "Sophie Taylor",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_EMILY = User(
    null,
    "emily-williams",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Emily",
    "Williams",
    Date(1993, 2, 26),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "emily_williams@gmail.com",
    "07000000008",
    52.8904728391023,
    -0.55678934567890,
    null,
    "Benjamin White",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_WILLIAM = User(
    null,
    "william-harris",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "William",
    "Harris",
    Date(1990, 6, 19),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "william_harris@gmail.com",
    "07000000009",
    51.7819283475910,
    -0.66789345678901,
    null,
    "Chloe Evans",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_LILY = User(
    null,
    "lily-clark",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Lily",
    "Clark",
    Date(1987, 5, 12),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "lily_clark@gmail.com",
    "07000000010",
    53.7810928347591,
    -0.77893456789012,
    null,
    "Liam Walker",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_HENRY = User(
    null,
    "henry-white",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Henry",
    "White",
    Date(1998, 10, 30),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "henry_white@gmail.com",
    "07000000011",
    52.6678934567890,
    -0.88934567890123,
    null,
    "Jessica Harris",
    mutableSetOf(RolesEnum.DOCTOR),
)


val USER_CHLOE = User(
    null,
    "chloe-davies",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Chloe",
    "Davies",
    Date(1983, 4, 21),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "chloe_davies@gmail.com",
    "07000000012",
    53.5567893456789,
    -1.0012345678901,
    null,
    "Daniel Clark",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_DANIEL = User(
    null,
    "daniel-king",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Daniel",
    "King",
    Date(1984, 8, 14),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "daniel_king@gmail.com",
    "07000000013",
    51.2234567823456,
    -0.1123456712345,
    null,
    "Grace Lewis",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_ISABELLA = User(
    null,
    "isabella-thompson",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Isabella",
    "Thompson",
    Date(1997, 11, 9),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "isabella_thompson@gmail.com",
    "07000000014",
    52.4567893456789,
    -1.2234567823456,
    null,
    "David Johnson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_JOSEPH = User(
    null,
    "joseph-evans",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Joseph",
    "Evans",
    Date(1992, 1, 27),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "joseph_evans@gmail.com",
    "07000000015",
    53.6678934567890,
    -0.3345678934567,
    null,
    "Emma Wilson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_SOPHIE = User(
    null,
    "sophie-brown",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Sophie",
    "Brown",
    Date(1986, 3, 29),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "sophie_brown@gmail.com",
    "07000000016",
    51.8910348723456,
    -0.4456789345678,
    null,
    "Michael Brown",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_HARRY = User(
    null,
    "harry-robinson",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Harry",
    "Robinson",
    Date(1989, 7, 22),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "harry_robinson@gmail.com",
    "07000000017",
    52.9810923475901,
    -0.5567893456789,
    null,
    "Sophie Taylor",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_GRACE = User(
    null,
    "grace-martin",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Grace",
    "Martin",
    Date(1994, 5, 8),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "grace_martin@gmail.com",
    "07000000018",
    51.2234567823456,
    -0.6678934567890,
    null,
    "Benjamin White",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_JAMES = User(
    null,
    "james-walker",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "James",
    "Walker",
    Date(1983, 2, 18),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "james_walker@gmail.com",
    "07000000019",
    52.3456789234567,
    -0.7789345678901,
    null,
    "Chloe Evans",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_MIA = User(
    null,
    "mia-hall",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Mia",
    "Hall",
    Date(1985, 11, 3),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "mia_hall@gmail.com",
    "07000000020",
    53.8904723456789,
    -0.8893456789012,
    null,
    "Jessica Harris",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_JOSEF = User(
    null,
    "josef-lewis",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Joseph",
    "Lewis",
    Date(1990, 9, 26),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "joseph_lewis@gmail.com",
    "07000000021",
    51.5678934567890,
    -1.0012345678901,
    null,
    "Daniel Clark",
    mutableSetOf(RolesEnum.DOCTOR),
)
val USER_RUBY = User(
    null,
    "ruby-martin",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Ruby",
    "Martin",
    Date(1992, 4, 13),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "ruby_martin@gmail.com",
    "07000000022",
    52.4578129345679,
    -0.3345678934567,
    null,
    "Grace Lewis",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_CHARLY = User(
    null,
    "charly-harris",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Charly",
    "Harris",
    Date(1986, 12, 21),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "charly_harris@gmail.com",
    "07000000023",
    51.6789234567890,
    -0.4456789345678,
    null,
    "Emma Wilson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_POPPY = User(
    null,
    "poppy-white",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Poppy",
    "White",
    Date(1994, 6, 17),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "poppy_white@gmail.com",
    "07000000024",
    53.7890123456789,
    -0.5567893456789,
    null,
    "Michael Brown",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_HAROLD = User(
    null,
    "harold-clark",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Harold",
    "Clark",
    Date(1988, 1, 3),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "harold_clark@gmail.com",
    "07000000025",
    52.3456789234567,
    -0.6678934567890,
    null,
    "Liam Walker",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_EVIE = User(
    null,
    "evie-baker",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Evie",
    "Baker",
    Date(1997, 7, 28),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "evie_baker@gmail.com",
    "07000000026",
    51.2234567823456,
    -0.7789345678901,
    null,
    "Jessica Harris",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_LEO = User(
    null,
    "leo-turner",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Leo",
    "Turner",
    Date(1991, 8, 15),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "leo_turner@gmail.com",
    "07000000027",
    53.1234567823456,
    -0.8893456789012,
    null,
    "Benjamin White",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_DAISY = User(
    null,
    "daisy-walker",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Daisy",
    "Walker",
    Date(1990, 9, 9),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "daisy_walker@gmail.com",
    "07000000028",
    52.5678934567890,
    -1.0012345678901,
    null,
    "Grace Lewis",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_OSCAR = User(
    null,
    "oscar-phillips",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Oscar",
    "Phillips",
    Date(1993, 11, 14),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "oscar_phillips@gmail.com",
    "07000000029",
    53.8904723456789,
    -1.1123456712345,
    null,
    "David Johnson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_LEAH = User(
    null,
    "leah-jackson",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Leah",
    "Jackson",
    Date(1985, 10, 2),
    SexEnum.FEMALE,
    mutableListOf("she/her"),
    "leah_jackson@gmail.com",
    "07000000030",
    52.8910348723456,
    -0.2234567823456,
    null,
    "Emma Wilson",
    mutableSetOf(RolesEnum.DOCTOR),
)

val USER_OLIVER = User(
    null,
    "oliver-evans",
    "\$2a\$12\$pQ5B6Dq2iH4BBMmUjLdV0.UBgdnFIHh16/8FmcaGBrVif8CsV/ZMy", // password
    "Oliver",
    "Evans",
    Date(1990, 2, 22),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "oliver_evans@gmail.com",
    "07000000031",
    51.7819283475910,
    -0.3345678934567,
    null,
    "Michael Brown",
    mutableSetOf(RolesEnum.DOCTOR),
)

val MOCK_USERS = listOf(
    USER_BARRY,
    USER_VINCENT,
    USER_CHARLIE,
    USER_OLIVIA,
    USER_JACK,
    USER_AMELIA,
    USER_GEORGE,
    USER_EMILY,
    USER_WILLIAM,
    USER_LILY,
    USER_HENRY,
    USER_CHLOE,
    USER_DANIEL,
    USER_ISABELLA,
    USER_JOSEPH,
    USER_SOPHIE,
    USER_HARRY,
    USER_GRACE,
    USER_JAMES,
    USER_MIA,
    USER_JOSEF,
    USER_RUBY,
    USER_CHARLY,
    USER_POPPY,
    USER_HAROLD,
    USER_EVIE,
    USER_LEO,
    USER_DAISY,
    USER_OSCAR,
    USER_LEAH,
    USER_OLIVER,
)
