/*
 * Copyright 2018-2025 Scala Steward contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.scalasteward.core.forge.github

import io.circe.Encoder
import io.circe.generic.semiauto.deriveEncoder
import org.scalasteward.core.forge.data.NewPullRequestData
import org.scalasteward.core.git.Branch

final case class CreatePullRequestPayload(
    title: String,
    body: String,
    head: String,
    base: Branch,
    draft: Boolean
)
object CreatePullRequestPayload {
  implicit val encoder: Encoder[CreatePullRequestPayload] = deriveEncoder

  def from(newPullRequestData: NewPullRequestData): CreatePullRequestPayload =
    CreatePullRequestPayload(
      title = newPullRequestData.title,
      body = newPullRequestData.body,
      head = newPullRequestData.head,
      base = newPullRequestData.base,
      draft = newPullRequestData.draft
    )
}
