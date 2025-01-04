package com.project.E_Notes.configur;

///  THIS CLASS TO SET WHO CREATED OR UPDATED CATEGORY AFTER AUTHENTICATION USER SAVE IN DB.

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AudiAwareConfi  implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.of(2); // default for temporary due to after spring security.
    }
}
