package cmp2804.tse.server.data.symptom

import cmp2804.tse.server.storage.specialties.Speciality


object MockSpecialties {

    val CARDIOLOGY = Speciality(
        null,
        "Cardiology",
        mutableSetOf(
            MockSymptoms.ARRHYTHMIA,
            MockSymptoms.BRADYCARDIA,
            MockSymptoms.BREATHING_DIFFICULTIES,
            MockSymptoms.CHEST_PAIN,
            MockSymptoms.CHEST_TIGHTNESS,
            MockSymptoms.COLLAPSING,
            MockSymptoms.DIZZINESS,
            MockSymptoms.ELEVATED_HEART_RATE,
            MockSymptoms.FAINTING,
            MockSymptoms.FATIGUE,
            MockSymptoms.HEART_PALPITATIONS,
            MockSymptoms.HEARTBURN,
            MockSymptoms.HIGH_BLOOD_PRESSURE,
            MockSymptoms.LOW_BLOOD_PRESSURE,
            MockSymptoms.PALPITATIONS,
            MockSymptoms.PRESSURE_IN_THE_CHEST,
            MockSymptoms.RAPID_HEART_RATE,
            MockSymptoms.SHORTNESS_OF_BREATH,
            MockSymptoms.SWEATING,
            MockSymptoms.SWELLING_IN_THE_LEGS,
            MockSymptoms.WEAKNESS,
            MockSymptoms.WEIGHT_GAIN,
        ),
        mutableSetOf()

    )

    val ONCOLOGY = Speciality(
        null,
        "Oncology",
        mutableSetOf(
            MockSymptoms.ABNORMAL_BLEEDING,
            MockSymptoms.BLOOD_IN_STOOL,
            MockSymptoms.BREAST_LUMPS,
            MockSymptoms.CONSTIPATION,
            MockSymptoms.DIARRHEA,
            MockSymptoms.DIFFICULTY_SWALLOWING,
            MockSymptoms.FATIGUE,
            MockSymptoms.PERSISTENT_COUGH,
            MockSymptoms.TESTICULAR_LUMPS,
            MockSymptoms.WEIGHT_LOSS
        ),
        mutableSetOf()
    )


    val GASTROENTEROLOGY = Speciality(
        null,
        "Gastroenterology",
        mutableSetOf(
            MockSymptoms.ABDOMINAL_BLOATING,
            MockSymptoms.ABDOMINAL_CRAMPS,
            MockSymptoms.ABDOMINAL_DISTENTION,
            MockSymptoms.ABDOMINAL_PAIN,
            MockSymptoms.ABDOMINAL_TENDERNESS,
            MockSymptoms.ACID_REFLUX,
            MockSymptoms.BELCHING,
            MockSymptoms.BLACK_STOOLS,
            MockSymptoms.BLOOD_IN_STOOL,
            MockSymptoms.BLOOD_IN_VOMIT,
            MockSymptoms.CHEST_PAIN,
            MockSymptoms.COLORECTAL_BLEEDING,
            MockSymptoms.CONSTIPATION,
            MockSymptoms.CRAMPING,
            MockSymptoms.DARK_URINE,
            MockSymptoms.DIARRHEA,
            MockSymptoms.DIFFICULTY_SWALLOWING,
            MockSymptoms.FATIGUE,
            MockSymptoms.FLATULENCE,
            MockSymptoms.GASSINESS,
            MockSymptoms.HEARTBURN,
            MockSymptoms.INDIGESTION,
            MockSymptoms.JAUNDICE,
            MockSymptoms.LOSS_OF_BOWEL_CONTROL,
            MockSymptoms.NAUSEA,
            MockSymptoms.PALE_STOOLS,
            MockSymptoms.RETCHING,
            MockSymptoms.STOMACH_PAIN,
            MockSymptoms.VOMITING,
            MockSymptoms.WEIGHT_FLUCTUATIONS,
            MockSymptoms.WEIGHT_GAIN,
            MockSymptoms.WEIGHT_LOSS,
        ),
        mutableSetOf(),
    )

    val PULMONOLOGY = Speciality(
        null,
        "Pulmonology",
        mutableSetOf(
            MockSymptoms.ASTHMA_ATTACKS,
            MockSymptoms.BREATHING_DIFFICULTIES,
            MockSymptoms.CHEST_PAIN,
            MockSymptoms.CHEST_TIGHTNESS,
            MockSymptoms.COUGH,
            MockSymptoms.COUGHING_UP_BLOOD,
            MockSymptoms.FATIGUE,
            MockSymptoms.HEAVY_BREATHING,
            MockSymptoms.LOUD_SNORING,
            MockSymptoms.NOISY_BREATHING,
            MockSymptoms.PERSISTENT_COUGH,
            MockSymptoms.SHORTNESS_OF_BREATH,
            MockSymptoms.WEIGHT_LOSS,
            MockSymptoms.WHEEZING,
        ),
        mutableSetOf()
    )

    val GYNECOLOGY = Speciality(
        null,
        "Gynecology",
        mutableSetOf(
            MockSymptoms.ABNORMAL_VAGINAL_BLEEDING,
            MockSymptoms.BREAST_LUMPS,
            MockSymptoms.BREAST_PAIN,
            MockSymptoms.BREAST_TENDERNESS,
            MockSymptoms.DYSMENORRHEA,
            MockSymptoms.DYSPAREUNIA,
            MockSymptoms.FATIGUE,
            MockSymptoms.HEAVY_PERIODS,
            MockSymptoms.INCREASED_THIRST,
            MockSymptoms.MENSTRUAL_IRREGULARITIES,
            MockSymptoms.PAINFUL_MENSTRUATION,
            MockSymptoms.PELVIC_PAIN,
            MockSymptoms.VAGINAL_DISCHARGE,
            MockSymptoms.VAGINAL_DRYNESS,
            MockSymptoms.VAGINAL_ITCHING,
            MockSymptoms.VAGINAL_SPOTTING,
        ),
        mutableSetOf()
    )

    val NEUROLOGY = Speciality(
        null,
        "Neurology",
        mutableSetOf(
            MockSymptoms.APHASIA,
            MockSymptoms.AUDITORY_HALLUCINATIONS,
            MockSymptoms.BALANCE_ISSUES,
            MockSymptoms.BLURRED_VISION,
            MockSymptoms.BRAIN_FOG,
            MockSymptoms.CHANGES_IN_BLADDER_FUNCTION,
            MockSymptoms.DIFFICULTY_CONCENTRATING,
            MockSymptoms.DIFFICULTY_SLEEPING,
            MockSymptoms.DIFFICULTY_SWALLOWING,
            MockSymptoms.DISORIENTATION,
            MockSymptoms.DIZZINESS,
            MockSymptoms.DOUBLE_VISION,
            MockSymptoms.EPILEPTIC_SEIZURES,
            MockSymptoms.HALLUCINATIONS,
            MockSymptoms.HEADACHES,
            MockSymptoms.IMPAIRED_COGNITION,
            MockSymptoms.IMPAIRED_COORDINATION,
            MockSymptoms.LOSS_OF_VISION,
            MockSymptoms.MEMORY_LOSS,
            MockSymptoms.MOOD_CHANGES,
            MockSymptoms.MUSCLE_WEAKNESS,
            MockSymptoms.NIGHTMARES,
            MockSymptoms.NUMBNESS,
            MockSymptoms.PARESTHESIA,
            MockSymptoms.RESTLESSNESS,
            MockSymptoms.SEIZURES,
            MockSymptoms.SLURRED_SPEECH,
            MockSymptoms.TREMORS,
            MockSymptoms.VERTIGO,
        ),
        mutableSetOf()
    )

    val DERMATOLOGY = Speciality(
        null,
        "Dermatology",
        mutableSetOf(
            MockSymptoms.BALDNESS,
            MockSymptoms.BLISTERS,
            MockSymptoms.BURNING_SENSATION,
            MockSymptoms.COLD_SORES,
            MockSymptoms.DARKENING_SKIN,
            MockSymptoms.DRY_SKIN,
            MockSymptoms.FACIAL_FLUSHING,
            MockSymptoms.FACIAL_SWELLING,
            MockSymptoms.HAIR_LOSS,
            MockSymptoms.INFLAMMATION,
            MockSymptoms.ITCHING,
            MockSymptoms.LIGHTENING_SKIN,
            MockSymptoms.NAIL_CHANGES,
            MockSymptoms.NAIL_CLUBBING,
            MockSymptoms.RASHES,
            MockSymptoms.REDNESS_OF_SKIN,
            MockSymptoms.SKIN_CHANGES,
            MockSymptoms.SKIN_DISCOLORATION,
            MockSymptoms.SKIN_IRRITATION,
            MockSymptoms.SKIN_LESIONS,
            MockSymptoms.SKIN_RASH,
            MockSymptoms.SWEATING,
            MockSymptoms.URTICARIA,
            MockSymptoms.WARTS,
        ),
        mutableSetOf()
    )


    val RHEUMATOLOGY = Speciality(
        null,
        "Rheumatology",
        mutableSetOf(
            MockSymptoms.ARM_PAIN,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.BLURRED_VISION,
            MockSymptoms.CHANGES_IN_JOINT_SHAPE,
            MockSymptoms.CHANGES_OF_FINGER_COLOUR,
            MockSymptoms.CHANGES_OF_TOE_COLOUR,
            MockSymptoms.FATIGUE,
            MockSymptoms.FEVER,
            MockSymptoms.FINGER_PAIN,
            MockSymptoms.FINGER_SWELLING,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.JOINT_STIFFNESS,
            MockSymptoms.JOINT_SWELLING,
            MockSymptoms.LOW_BACK_PAIN,
            MockSymptoms.MORNING_STIFFNESS,
            MockSymptoms.MUSCLE_CRAMPS,
            MockSymptoms.MUSCLE_PAIN,
            MockSymptoms.MUSCLE_SPASMS,
            MockSymptoms.MUSCLE_STIFFNESS,
            MockSymptoms.MUSCLE_WEAKNESS,
            MockSymptoms.SENSITIVITY_TO_SUNLGIHT,
            MockSymptoms.SKIN_RASH,
            MockSymptoms.SWELLING,
            MockSymptoms.WATERY_EYES,

            ),
        mutableSetOf()
    )

    val UROLOGY = Speciality(
        null,
        "Urology",
        mutableSetOf(
            MockSymptoms.BLADDER_CONTROL_ISSUES,
            MockSymptoms.BLADDER_PAIN,
            MockSymptoms.BLADDER_SPASMS,
            MockSymptoms.BLOOD_IN_URINE,
            MockSymptoms.CLOUDY_URINE,
            MockSymptoms.DIFFICULTY_PASSING_URINE,
            MockSymptoms.DYSURIA,
            MockSymptoms.ENLARGED_SPLEEN,
            MockSymptoms.ERECTILE_DYSFUNCTION,
            MockSymptoms.FREQUENT_URINATION,
            MockSymptoms.NAUSEA,
            MockSymptoms.PAINFUL_URINATION,
            MockSymptoms.PELVIC_PAIN,
            MockSymptoms.PENILE_DISCHARGE,
            MockSymptoms.TESTICULAR_PAIN,
            MockSymptoms.URETHRAL_DISCHARGE,
            MockSymptoms.URINE_LEAKAGE,
            MockSymptoms.VOMITING,
        ),
        mutableSetOf()
    )

    val OTOLARYNGOLOGY = Speciality(
        null,
        "Otolaryngology",
        mutableSetOf(
            MockSymptoms.BAD_BREATH,
            MockSymptoms.COUGH,
            MockSymptoms.EAR_DISCHARGE,
            MockSymptoms.EAR_RINGING,
            MockSymptoms.EARACHE,
            MockSymptoms.FACIAL_FLUSHING,
            MockSymptoms.HEARING_LOSS,
            MockSymptoms.HOARSENESS,
            MockSymptoms.POST_NASAL_DRIP,
            MockSymptoms.RINGING_IN_THE_EARS,
            MockSymptoms.SINUS_CONGESTION,
            MockSymptoms.SINUS_HEADACHES,
            MockSymptoms.SINUS_PRESSURE,
            MockSymptoms.SNORING,
            MockSymptoms.SORE_THROAT,
            MockSymptoms.SWELLING,
            MockSymptoms.VOICE_CHANGES
        ),
        mutableSetOf()
    )

    val ORTHOPEDICS = Speciality(
        null,
        "Orthopedics",
        mutableSetOf(
            MockSymptoms.ANKLE_PAIN,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.DIFFICULTY_WEIGHT_BEARING,
            MockSymptoms.ELBOW_PAIN,
            MockSymptoms.FINGER_PAIN,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.JOINT_STIFFNESS,
            MockSymptoms.JOINT_SWELLING,
            MockSymptoms.KNEE_PAIN,
            MockSymptoms.LOW_BACK_PAIN,
            MockSymptoms.MUSCLE_PAIN,
            MockSymptoms.MUSCLE_WEAKNESS,
            MockSymptoms.NECK_PAIN,
            MockSymptoms.NECK_STIFFNESS,
            MockSymptoms.REDUCED_MOBILITY,
            MockSymptoms.SHOULDER_PAIN,
            MockSymptoms.SPINAL_PAIN,
            MockSymptoms.WRIST_PAIN
        ),
        mutableSetOf()
    )

    val PSYCHIATRY = Speciality(
        null,
        "Psychiatry",
        mutableSetOf(
            MockSymptoms.ANXIETY,
            MockSymptoms.DELUSIONS,
            MockSymptoms.DEPRESSION,
            MockSymptoms.HALLUCINATIONS,
            MockSymptoms.LACK_OF_CONCENTRATION,
            MockSymptoms.LACK_OF_LIBIDO,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.NIGHTMARES,
            MockSymptoms.PANIC_ATTACKS,
            MockSymptoms.RESTLESSNESS,
            MockSymptoms.SLURRED_SPEECH,
            MockSymptoms.STRESS,
            MockSymptoms.MOOD_CHANGES,
            MockSymptoms.ANXIETY,
            MockSymptoms.DIFFICULTY_SLEEPING,
            MockSymptoms.DEPRESSION,
            MockSymptoms.LOSS_OF_APPETITE,
            MockSymptoms.WEIGHT_LOSS,
            MockSymptoms.WEIGHT_GAIN,
            MockSymptoms.DIFFICULTY_CONCENTRATING,
            MockSymptoms.SUICIDAL,
            MockSymptoms.HALLUCINATIONS,
            MockSymptoms.HEADACHES,
            MockSymptoms.STOMACH_PAIN,

            ),
        mutableSetOf()
    )


    val ENDOCRINOLOGY = Speciality(
        null,
        "Endocrinology",
        mutableSetOf(
            MockSymptoms.ANXIETY,
            MockSymptoms.DEPRESSION,
            MockSymptoms.ERECTILE_DYSFUNCTION,
            MockSymptoms.EXAUSTION,
            MockSymptoms.FATIGUE,
            MockSymptoms.HAIR_LOSS,
            MockSymptoms.HIGH_BLOOD_PRESSURE,
            MockSymptoms.INCREASED_APPETITE,
            MockSymptoms.INCREASED_SWEATING,
            MockSymptoms.INCREASED_THIRST,
            MockSymptoms.INSOMNIA,
            MockSymptoms.LOSS_OF_APPETITE,
            MockSymptoms.LOW_GRADE_FEVER,
            MockSymptoms.LOW_LIBIDO,
            MockSymptoms.MISSED_PERIODS,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.NIGHT_SWEATS,
            MockSymptoms.THIRSTINESS,
            MockSymptoms.WEAKNESS,
            MockSymptoms.WEIGHT_FLUCTUATIONS,
            MockSymptoms.WEIGHT_GAIN,
            MockSymptoms.WEIGHT_LOSS,
        ),
        mutableSetOf()
    )

    val IMMUNOLOGY = Speciality(
        null,
        "Immunology",
        mutableSetOf(
            MockSymptoms.ABSCESSES,
            MockSymptoms.CHEST_PAIN,
            MockSymptoms.COLD_SORES,
            MockSymptoms.COUGH,
            MockSymptoms.DANDRUFF,
            MockSymptoms.DELAYED_WOUND_HEALING,
            MockSymptoms.DRY_MOUTH,
            MockSymptoms.EDEMA,
            MockSymptoms.EYE_STRAIN,
            MockSymptoms.FEVER,
            MockSymptoms.FLUID_RETENTION,
            MockSymptoms.FREQUENT_INFECTIONS,
            MockSymptoms.ITCHY_SCALP,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.LYMPH_NODE_SWELLING,
            MockSymptoms.NASAL_CONGESTION,
            MockSymptoms.NASAL_DISCHARGE,
            MockSymptoms.NAUSEA,
            MockSymptoms.SKIN_RASH,
            MockSymptoms.SNEEZING,
            MockSymptoms.SWELLING,
            MockSymptoms.SWOLLEN_GLANDS,
            MockSymptoms.VOMITING,
            MockSymptoms.WATERY_EYES,
            MockSymptoms.WHEEZING
        ),
        mutableSetOf()
    )

    val OPHTHALMOLOGY = Speciality(
        null,
        "Ophthalmology",
        mutableSetOf(
            MockSymptoms.BLURRED_VISION,
            MockSymptoms.DOUBLE_VISION,
            MockSymptoms.EYE_FLOATERS,
            MockSymptoms.EYE_IRRITATION,
            MockSymptoms.EYE_REDNESS,
            MockSymptoms.EYE_STRAIN,
            MockSymptoms.EYELID_TWITCHING,
            MockSymptoms.FLOATERS_IN_VISION,
            MockSymptoms.HEADACHES,
            MockSymptoms.ORTHOSTATIC_HYPOTENSION,
            MockSymptoms.PHOTOSENSITIVITY,
            MockSymptoms.VISION_CHANGES
        ),
        mutableSetOf()
    )

    val HEMATOLOGY = Speciality(
        null,
        "Hematology",
        mutableSetOf(
            MockSymptoms.BLOOD_IN_STOOL,
            MockSymptoms.BLOOD_IN_URINE,
            MockSymptoms.BLOOD_IN_VOMIT,
            MockSymptoms.BRUISING_EASILY,
            MockSymptoms.CHILLS,
            MockSymptoms.EASY_BRUISING,
            MockSymptoms.ENLARGED_LYMPH_NODES,
            MockSymptoms.FATIGUE,
            MockSymptoms.FEVER,
            MockSymptoms.LOW_BLOOD_PRESSURE,
            MockSymptoms.SHORTNESS_OF_BREATH,
            MockSymptoms.SPLEEN_ENLARGEMENT,
            MockSymptoms.SPONTANEOUS_BLEEDING,
            MockSymptoms.WEAKNESS,
        ),
        mutableSetOf()
    )


    val INFECTIOUS_DISEASES = Speciality(
        null,
        "Infectious Diseases",
        mutableSetOf(
            MockSymptoms.BODY_ACHES,
            MockSymptoms.BODY_CHILLS,
            MockSymptoms.BODY_TEMPERATURE_FLUCTUATIONS,
            MockSymptoms.CHILLS,
            MockSymptoms.FATIGUE,
            MockSymptoms.FEVER,
            MockSymptoms.GENITAL_DISCHARGE,
            MockSymptoms.GENITAL_ITCHING,
            MockSymptoms.GENITAL_ULCERS,
            MockSymptoms.LOW_GRADE_FEVER,
            MockSymptoms.LUNG_CONGESTION,
            MockSymptoms.NIGHT_SWEATS,
            MockSymptoms.PERSISTENT_COUGH,
            MockSymptoms.SNORING,
            MockSymptoms.SORE_THROAT,
            MockSymptoms.WEIGHT_LOSS,
        ),
        mutableSetOf()
    )

    val NEPHROLOGY = Speciality(
        null,
        "Nephrology",
        mutableSetOf(
            MockSymptoms.BLADDER_PAIN,
            MockSymptoms.BLADDER_CONTROL_ISSUES,
            MockSymptoms.BLADDER_SPASMS,
            MockSymptoms.BLOOD_IN_URINE,
            MockSymptoms.CHANGES_IN_URINE_COLOUR,
            MockSymptoms.CHANGES_IN_URINE_ODOUR,
            MockSymptoms.DARK_URINE,
            MockSymptoms.ENLARGED_SPLEEN,
            MockSymptoms.FATIGUE,
            MockSymptoms.FREQUENT_URINATION,
            MockSymptoms.HIGH_BLOOD_PRESSURE,
            MockSymptoms.OLIGURIA,
            MockSymptoms.PAINFUL_URINATION,
            MockSymptoms.SWELLING,
            MockSymptoms.URINE_LEAKAGE,
            MockSymptoms.WEAKNESS,

            ),
        mutableSetOf()
    )


    val NEONATOLOGY = Speciality(
        null,
        "Neonatology",
        mutableSetOf(
            MockSymptoms.BELCHING,
            MockSymptoms.BREATHING_DIFFICULTIES,
            MockSymptoms.COUGH,
            MockSymptoms.DROOLING,
            MockSymptoms.FREQUENT_URINATION,
            MockSymptoms.HEAVY_BREATHING,
            MockSymptoms.SLEEP_DISTURBANCES
        ),
        mutableSetOf()
    )

    val GERIATRICS = Speciality(
        null,
        "Geriatrics",
        mutableSetOf(
            MockSymptoms.BACK_PAIN,
            MockSymptoms.CHRONIC_FATIGUE,
            MockSymptoms.COORDINATION_ISSUES,
            MockSymptoms.LOSS_OF_MOTOR_SKILLS,
            MockSymptoms.MEMORY_LOSS,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.POOR_MOTOR_SKILLS,
            MockSymptoms.TREMORS,
            MockSymptoms.WEAKNESS
        ),
        mutableSetOf()
    )


    val PAIN_MANAGEMENT = Speciality(
        null,
        "Pain Management",
        mutableSetOf(
            MockSymptoms.ABDOMINAL_PAIN,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.CHRONIC_PAIN,
            MockSymptoms.HEADACHES,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.MIGRAINE,
            MockSymptoms.SHOULDER_PAIN
        ),
        mutableSetOf()
    )

    val PEDIATRICS = Speciality(
        null,
        "Pediatrics",
        mutableSetOf(
            MockSymptoms.ANXIETY,
            MockSymptoms.COUGH,
            MockSymptoms.DIFFICULTY_CONCENTRATING,
            MockSymptoms.HYPERACTIVITY,
            MockSymptoms.SLEEP_DISTURBANCES
        ),
        mutableSetOf()
    )

    val PLASTIC_SURGERY = Speciality(
        null,
        "Plastic Surgery",
        mutableSetOf(
            MockSymptoms.COLD_SORES,
            MockSymptoms.FACIAL_FLUSHING,
            MockSymptoms.SKIN_CHANGES,
            MockSymptoms.SKIN_DISCOLORATION
        ),
        mutableSetOf()
    )

    val PROCTOLOGY = Speciality(
        null,
        "Proctology",
        mutableSetOf(
            MockSymptoms.ABDOMINAL_PAIN,
            MockSymptoms.BLOOD_IN_STOOL,
            MockSymptoms.CHRONIC_PAIN,
            MockSymptoms.HEMORRHOIDS,
            MockSymptoms.LOSS_OF_BOWEL_CONTROL,
            MockSymptoms.RECTAL_BLEEDING
        ),
        mutableSetOf()
    )

    val SEXOLOGY = Speciality(
        null,
        "Sexology",
        mutableSetOf(
            MockSymptoms.DYSPAREUNIA,
            MockSymptoms.ERECTILE_DYSFUNCTION,
            MockSymptoms.LACK_OF_LIBIDO,
            MockSymptoms.SEXUAL_DYSFUNCTION,
            MockSymptoms.STRESS
        ),
        mutableSetOf()
    )

    val SLEEP_MEDICINE = Speciality(
        null,
        "Sleep Medicine",
        mutableSetOf(
            MockSymptoms.INSOMNIA,
            MockSymptoms.NIGHT_SWEATS,
            MockSymptoms.NIGHTMARES,
            MockSymptoms.RESTLESSNESS,
            MockSymptoms.SLEEP_DISTURBANCES,
            MockSymptoms.SNORING,
        ),
        mutableSetOf()
    )

    val GENERAL_PRACTICE = Speciality(
        null,
        "General Practice",
        mutableSetOf(
            MockSymptoms.BACK_PAIN,
            MockSymptoms.BODY_ACHES,
            MockSymptoms.FATIGUE,
            MockSymptoms.INDIGESTION,
            MockSymptoms.LOSS_OF_APPETITE,
            MockSymptoms.LOW_GRADE_FEVER,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.STRESS
        ),
        mutableSetOf()
    )

    val SPORTS_MEDICINE = Speciality(
        null,
        "Sports Medicine",
        mutableSetOf(
            MockSymptoms.ANKLE_SWELLING,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.ELBOW_PAIN,
            MockSymptoms.FINGER_PAIN,
            MockSymptoms.JOINT_SWELLING,
            MockSymptoms.KNEE_PAIN,
            MockSymptoms.MUSCLE_PAIN,
            MockSymptoms.NECK_STIFFNESS,
            MockSymptoms.SHOULDER_PAIN,
            MockSymptoms.WRIST_PAIN
        ),
        mutableSetOf()
    )


    val THERAPY = Speciality(
        null,
        "Therapy",
        mutableSetOf(
            MockSymptoms.ANXIETY,
            MockSymptoms.DEPRESSION,
            MockSymptoms.LACK_OF_CONCENTRATION,
            MockSymptoms.LACK_OF_ENERGY,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.NERVOUSNESS,
            MockSymptoms.RESTLESSNESS,
            MockSymptoms.STRESS
        ),
        mutableSetOf()
    )

    fun all(): List<Speciality> {
        return listOf(
            CARDIOLOGY,
            ONCOLOGY,
            GASTROENTEROLOGY,
            PULMONOLOGY,
            GYNECOLOGY,
            NEUROLOGY,
            DERMATOLOGY,
            RHEUMATOLOGY,
            UROLOGY,
            OTOLARYNGOLOGY,
            ORTHOPEDICS,
            PSYCHIATRY,
            ENDOCRINOLOGY,
            IMMUNOLOGY,
            OPHTHALMOLOGY,
            HEMATOLOGY,
            INFECTIOUS_DISEASES,
            NEPHROLOGY,
            NEONATOLOGY,
            GERIATRICS,
            PAIN_MANAGEMENT,
            PEDIATRICS,
            PLASTIC_SURGERY,
            PROCTOLOGY,
            SEXOLOGY,
            SLEEP_MEDICINE,
            GENERAL_PRACTICE,
            SPORTS_MEDICINE,
            THERAPY,
        )
    }

}