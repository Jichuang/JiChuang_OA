package org.hope6537.dao.impl;

import org.hope6537.dao.VersionDao;
import org.hope6537.model.Version;
import org.springframework.stereotype.Repository;

@Repository("versionDao")
public class VersionDaoImpl extends BaseDaoImpl<Version> implements VersionDao {

}
