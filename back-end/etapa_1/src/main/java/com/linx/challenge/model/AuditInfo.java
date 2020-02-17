package com.linx.challenge.model;

import com.linx.challenge.model.pojo.AuditInfoPOJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditInfo {

    private String updatedBy;

    private String updatedThrough;

    public AuditInfo(AuditInfoPOJO auditInfo) {
        this.updatedBy = auditInfo.updatedBy;
        this.updatedThrough = auditInfo.updatedThrough;
    }
}
