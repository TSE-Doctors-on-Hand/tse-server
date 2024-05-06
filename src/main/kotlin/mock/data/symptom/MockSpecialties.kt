package mock.data.symptom

import cmp2804.tse.server.storage.specialties.Speciality


object MockSpecialties {

    val CARDIOLOGY = Speciality(
        null,
        "Cadriology",
        mutableSetOf(
            MockSymptoms.ARRHYTHMIA,
            MockSymptoms.ARTERIAL_STIFFENING,
            MockSymptoms.ATRIAL_FIBRILLATION,
            MockSymptoms.BRADYCARDIA,
            MockSymptoms.BREATHING_DIFFICULTIES,
            MockSymptoms.CARDIAC_ARRHYTHMIAS,
            MockSymptoms.CHEST_PAIN,
            MockSymptoms.CHEST_TIGHTNESS,
            MockSymptoms.COLLAPSING,
            MockSymptoms.ELEVATED_HEART_RATE,
            MockSymptoms.FATIGUE,
            MockSymptoms.HEART_PALPITATIONS,
            MockSymptoms.HEARTBURN,
            MockSymptoms.HYPERTENSION,
            MockSymptoms.LOW_BLOOD_PRESSURE,
            MockSymptoms.PALPITATIONS,
            MockSymptoms.PRESSURE_IN_THE_CHEST,
            MockSymptoms.RAPID_HEART_RATE,
            MockSymptoms.SWEATING,
            MockSymptoms.SYNCOPE
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
            MockSymptoms.BOWEL_INCONTINENCE,
            MockSymptoms.COLORECTAL_BLEEDING,
            MockSymptoms.CONSTIPATION,
            MockSymptoms.CRAMPING,
            MockSymptoms.DIARRHEA,
            MockSymptoms.FLATULENCE,
            MockSymptoms.GAS,
            MockSymptoms.INDIGESTION,
            MockSymptoms.STOMACH_PAIN,
            MockSymptoms.VOMITING,
            MockSymptoms.WEIGHT_FLUCTUATIONS
        ),
        mutableSetOf(),
    )

    val PULMONOLOGY = Speciality(
        null,
        "Pulmonology",
        mutableSetOf(
            MockSymptoms.ASTHMA,
            MockSymptoms.BREATHING_DIFFICULTIES,
            MockSymptoms.CHEST_PAIN,
            MockSymptoms.COUGH,
            MockSymptoms.FATIGUE,
            MockSymptoms.FLU_LIKE_SYMPTOMS,
            MockSymptoms.HEAVY_BREATHING,
            MockSymptoms.SHORTNESS_OF_BREATH,
            MockSymptoms.WHEEZING
        ),
        mutableSetOf()
    )

    val GYNECOLOGY = Speciality(
        null,
        "Gynecology",
        mutableSetOf(
            MockSymptoms.BREAST_LUMPS,
            MockSymptoms.BREAST_PAIN,
            MockSymptoms.BREAST_TENDERNESS,
            MockSymptoms.DYSMENORRHEA,
            MockSymptoms.DYSPAREUNIA,
            MockSymptoms.FATIGUE,
            MockSymptoms.HEAVY_PERIODS,
            MockSymptoms.INCREASED_THIRST,
            MockSymptoms.MENSTRUAL_IRREGULARITIES,
            MockSymptoms.PELVIC_PAIN,
            MockSymptoms.VAGINAL_DISCHARGE,
            MockSymptoms.VAGINAL_DRYNESS,
            MockSymptoms.VAGINAL_ITCHING,
            MockSymptoms.VAGINAL_SPOTTING
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
            MockSymptoms.BRAIN_FOG,
            MockSymptoms.DELIRIUM,
            MockSymptoms.DIFFICULTY_CONCENTRATING,
            MockSymptoms.DISORIENTATION,
            MockSymptoms.DIZZINESS,
            MockSymptoms.EPILEPTIC_SEIZURES,
            MockSymptoms.HALLUCINATIONS,
            MockSymptoms.HEADACHES,
            MockSymptoms.IMPAIRED_COGNITION,
            MockSymptoms.IMPAIRED_COORDINATION,
            MockSymptoms.MEMORY_LOSS,
            MockSymptoms.NIGHTMARES,
            MockSymptoms.NUMBNESS,
            MockSymptoms.PARESTHESIA,
            MockSymptoms.RESTLESSNESS,
            MockSymptoms.SEIZURES,
            MockSymptoms.SLURRED_SPEECH,
            MockSymptoms.STROKE_LIKE_SYMPTOMS,
            MockSymptoms.TREMORS
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
            MockSymptoms.DRY_SKIN,
            MockSymptoms.FACIAL_FLUSHING,
            MockSymptoms.FACIAL_SWELLING,
            MockSymptoms.ITCHING,
            MockSymptoms.NAIL_CHANGES,
            MockSymptoms.RASHES,
            MockSymptoms.SKIN_CHANGES,
            MockSymptoms.SKIN_DISCOLORATION,
            MockSymptoms.SKIN_IRRITATION,
            MockSymptoms.SKIN_LESIONS,
            MockSymptoms.SWEATING,
            MockSymptoms.URTICARIA
        ),
        mutableSetOf()
    )


    val RHEUMATOLOGY = Speciality(
        null,
        "Rheumatology",
        mutableSetOf(
            MockSymptoms.ARM_PAIN,
            MockSymptoms.ARTHRITIS,
            MockSymptoms.AUTOIMMUNE_REACTIONS,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.FIBROMYALGIA_LIKE_SYMPTOMS,
            MockSymptoms.FINGER_PAIN,
            MockSymptoms.FINGER_SWELLING,
            MockSymptoms.GOUT,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.JOINT_STIFFNESS,
            MockSymptoms.JOINT_SWELLING,
            MockSymptoms.LOW_BACK_PAIN,
            MockSymptoms.MUSCLE_ATROPHY,
            MockSymptoms.MUSCLE_CRAMPS,
            MockSymptoms.MUSCLE_PAIN,
            MockSymptoms.MUSCLE_SPASMS,
            MockSymptoms.MUSCLE_STIFFNESS,
            MockSymptoms.MUSCLE_WEAKNESS
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
            MockSymptoms.DYSURIA,
            MockSymptoms.ENLARGED_SPLEEN,
            MockSymptoms.ERECTILE_DYSFUNCTION,
            MockSymptoms.FREQUENT_URINATION,
            MockSymptoms.PAINFUL_URINATION,
            MockSymptoms.PENILE_DISCHARGE,
            MockSymptoms.URETHRAL_DISCHARGE,
            MockSymptoms.URINARY_FREQUENCY,
            MockSymptoms.URINARY_INCONTINENCE,
            MockSymptoms.URINARY_TRACT_INFECTIONS,
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
            MockSymptoms.EAR_INFECTIONS,
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
            MockSymptoms.ARTHRITIS,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.BROKEN_BONES,
            MockSymptoms.CARPAL_TUNNEL_SYNDROME,
            MockSymptoms.CLAUDICATION,
            MockSymptoms.DISLOCATED_JOINTS,
            MockSymptoms.ELBOW_PAIN,
            MockSymptoms.FINGER_PAIN,
            MockSymptoms.KNEE_PAIN,
            MockSymptoms.LOW_BACK_PAIN,
            MockSymptoms.NECK_PAIN,
            MockSymptoms.NECK_STIFFNESS,
            MockSymptoms.OSTEOPOROSIS,
            MockSymptoms.SCIATICA,
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
            MockSymptoms.AGITATION,
            MockSymptoms.ANXIETY,
            MockSymptoms.ATTENTION_DEFICIT,
            MockSymptoms.DELUSIONS,
            MockSymptoms.DEPRESSION,
            MockSymptoms.FRUSTRATION,
            MockSymptoms.HALLUCINATIONS,
            MockSymptoms.LACK_OF_CONCENTRATION,
            MockSymptoms.LACK_OF_LIBIDO,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.NIGHTMARES,
            MockSymptoms.PANIC_ATTACKS,
            MockSymptoms.RESTLESSNESS,
            MockSymptoms.SLURRED_SPEECH,
            MockSymptoms.STRESS
        ),
        mutableSetOf()
    )


    val ENDOCRINOLOGY = Speciality(
        null,
        "Endocrinology",
        mutableSetOf(
            MockSymptoms.DEPRESSION,
            MockSymptoms.FATIGUE,
            MockSymptoms.HAIR_LOSS,
            MockSymptoms.HYPERTENSION,
            MockSymptoms.HYPERTHERMIA,
            MockSymptoms.HYPOTHERMIA,
            MockSymptoms.INCREASED_APPETITE,
            MockSymptoms.INCREASED_SWEATING,
            MockSymptoms.INCREASED_THIRST,
            MockSymptoms.INSOMNIA,
            MockSymptoms.LOW_GRADE_FEVER,
            MockSymptoms.WEIGHT_FLUCTUATIONS
        ),
        mutableSetOf()
    )

    val IMMUNOLOGY = Speciality(
        null,
        "Immunology",
        mutableSetOf(
            MockSymptoms.ALLERGIES,
            MockSymptoms.AUTOIMMUNE_REACTIONS,
            MockSymptoms.CATARRH,
            MockSymptoms.COLD_SORES,
            MockSymptoms.DANDRUFF,
            MockSymptoms.EDEMA,
            MockSymptoms.FIBROMYALGIA_LIKE_SYMPTOMS,
            MockSymptoms.FLUID_RETENTION,
            MockSymptoms.HAY_FEVER,
            MockSymptoms.ITCHY_SCALP,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.LYMPH_NODE_SWELLING,
            MockSymptoms.SKIN_RASH,
            MockSymptoms.SWELLING,
            MockSymptoms.SWOLLEN_GLANDS
        ),
        mutableSetOf()
    )

    val OPHTHALMOLOGY = Speciality(
        null,
        "Ophthalmology",
        mutableSetOf(
            MockSymptoms.BLURRED_VISION,
            MockSymptoms.CATARACTS,
            MockSymptoms.DOUBLE_VISION,
            MockSymptoms.EYE_FLOATERS,
            MockSymptoms.EYE_IRRITATION,
            MockSymptoms.EYE_REDNESS,
            MockSymptoms.EYE_STRAIN,
            MockSymptoms.EYELID_TWITCHING,
            MockSymptoms.FLOATERS_IN_VISION,
            MockSymptoms.HEADACHES,
            MockSymptoms.ORTHOSTATIC_HYPOTENSION,
            MockSymptoms.PERIPHERAL_NEUROPATHY,
            MockSymptoms.PHOTOSENSITIVITY,
            MockSymptoms.RETINAL_DETACHMENT,
            MockSymptoms.RETINOPATHY,
            MockSymptoms.VISION_CHANGES
        ),
        mutableSetOf()
    )

    val HEMATOLOGY = Speciality(
        null,
        "Hematology",
        mutableSetOf(
            MockSymptoms.ANEMIA,
            MockSymptoms.BRUISING_EASILY,
            MockSymptoms.ENLARGED_LYMPH_NODES,
            MockSymptoms.FATIGUE,
            MockSymptoms.FEVER,
            MockSymptoms.LOW_BLOOD_PRESSURE,
            MockSymptoms.SPLEEN_ENLARGEMENT
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
            MockSymptoms.FEVER,
            MockSymptoms.FLU_LIKE_SYMPTOMS,
            MockSymptoms.LOW_GRADE_FEVER,
            MockSymptoms.LUNG_CONGESTION,
            MockSymptoms.PERSISTENT_COUGH,
            MockSymptoms.SNORING,
            MockSymptoms.SORE_THROAT
        ),
        mutableSetOf()
    )

    val NEPHROLOGY = Speciality(
        null,
        "Nephrology",
        mutableSetOf(
            MockSymptoms.BLADDER_STONES,
            MockSymptoms.BLOOD_IN_URINE,
            MockSymptoms.DARK_URINE,
            MockSymptoms.ENLARGED_SPLEEN,
            MockSymptoms.HEPATOMEGALY,
            MockSymptoms.OLIGURIA,
            MockSymptoms.SWELLING,
            MockSymptoms.URINARY_INCONTINENCE,
            MockSymptoms.URINARY_TRACT_INFECTIONS
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
            MockSymptoms.CROUP,
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
            MockSymptoms.DEMENTIA_SYMPTOMS,
            MockSymptoms.LOSS_OF_MOTOR_SKILLS,
            MockSymptoms.MEMORY_LOSS,
            MockSymptoms.MOOD_SWINGS,
            MockSymptoms.POOR_MOTOR_SKILLS,
            MockSymptoms.STROKE_LIKE_SYMPTOMS,
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
            MockSymptoms.ARTHRITIS,
            MockSymptoms.BACK_PAIN,
            MockSymptoms.CHRONIC_PAIN,
            MockSymptoms.HEADACHES,
            MockSymptoms.JOINT_PAIN,
            MockSymptoms.MIGRAINE,
            MockSymptoms.SCIATICA,
            MockSymptoms.SHOULDER_PAIN
        ),
        mutableSetOf()
    )

    val PEDIATRICS = Speciality(
        null,
        "Pediatrics",
        mutableSetOf(
            MockSymptoms.ALLERGIES,
            MockSymptoms.ANXIETY,
            MockSymptoms.ASTHMA,
            MockSymptoms.ATTENTION_DEFICIT,
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
            MockSymptoms.BOWEL_INCONTINENCE,
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
            MockSymptoms.GENITAL_SYMPTOMS,
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
            MockSymptoms.SLEEP_APNEA,
            MockSymptoms.SLEEP_DISTURBANCES,
            MockSymptoms.SNORING,
            MockSymptoms.SYNCOPE
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
            MockSymptoms.FLU_LIKE_SYMPTOMS,
            MockSymptoms.FRUSTRATION,
            MockSymptoms.INDIGESTION,
            MockSymptoms.LOSS_OF_APPETITE,
            MockSymptoms.LOW_GRADE_FEVER,
            MockSymptoms.MALAISE,
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
            MockSymptoms.CLAUDICATION,
            MockSymptoms.DISLOCATED_JOINTS,
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
}