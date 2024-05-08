package cmp2804.tse.server.data

import cmp2804.tse.server.storage.practices.Practice


val PRACTICE_STUDENT = Practice(
    null,
    "University of Lincoln Student Health Centre",
    53.22917714223162,
    -0.5487081633902697,
    "153-157 Clarence St, Kingston upon Thames KT1 1QT",
    setOf()
)
val PRACTICE_NEWLAND = Practice(
    null,
    "Newland Health Centre",
    53.23003491906554,
    -0.5446511364705648,
    "Newland Health Centre, 34 Newland, Lincoln LN1 1XP",
    setOf()
)

val PRACTICE_CLIFF = Practice(
    null,
    "Cliff House Medical Practice",
    53.23295388840799,
    -0.5521003179079724,
    "24 Gresham St, Lincoln LN1 1PZ",
    setOf()
)

val MOCK_PRACTICES = listOf(
    PRACTICE_STUDENT,
    PRACTICE_NEWLAND,
    PRACTICE_CLIFF
)