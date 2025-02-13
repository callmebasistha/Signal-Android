/*
 * Copyright 2023 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.thoughtcrime.securesms.database.helpers.migration

import android.app.Application
import net.zetetic.database.sqlcipher.SQLiteDatabase

/**
 * PNIs were incorrectly being set to ACI column, remove them if present.
 */
@Suppress("ClassName")
object V208_ClearRecipientPniFromAciColumn : SignalDatabaseMigration {
  override fun migrate(context: Application, db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    db.execSQL("DELETE FROM recipient WHERE aci LIKE 'PNI:%'")
  }
}
