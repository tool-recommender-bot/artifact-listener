package fr.openwide.maven.artifact.notifier.core.business.artifact.dao;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;

import fr.openwide.core.jpa.business.generic.dao.GenericEntityDaoImpl;
import fr.openwide.maven.artifact.notifier.core.business.artifact.model.Artifact;
import fr.openwide.maven.artifact.notifier.core.business.artifact.model.ArtifactVersion;
import fr.openwide.maven.artifact.notifier.core.business.artifact.model.QArtifactVersion;

@Repository("artifactVersionDao")
public class ArtifactVersionDaoImpl extends GenericEntityDaoImpl<Long, ArtifactVersion> implements IArtifactVersionDao {

	private static final QArtifactVersion qArtifactVersion = QArtifactVersion.artifactVersion;
	
	@Override
	public ArtifactVersion getByArtifactAndVersion(Artifact artifact, String version) {
		JPAQuery query = new JPAQuery(getEntityManager());
		
		query.from(qArtifactVersion)
			.where(qArtifactVersion.artifact.eq(artifact),
					qArtifactVersion.version.eq(version));
		
		return query.singleResult(qArtifactVersion);
	}
	
}
