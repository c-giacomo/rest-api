/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api.rest.web.resources;

import com.api.rest.model.bean.user.User;
import com.api.rest.model.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Min;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-06T20:20:17.683423600+01:00[Europe/Rome]", comments = "Generator version: 7.10.0")
@Validated
@Tag(name = "User", description = "Operation concerning Users")
@RequestMapping("${openapi.exampleRestArchetype.base-path:}")
public interface UsersApi {

    /**
     * GET /users/{id} : Get User with respective ID
     * Get user by his ID.
     *
     * @param id The ID of object to be returned (required)
     * @return Successful operation (status code 200)
     *         or Invalid id supplied (status code 400)
     *         or User not found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getUserId",
        summary = "Get User with respective ID",
        description = "Get user by his ID.",
        tags = { "User" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @GetMapping(
        value = "/users/{id}",
        produces = { "application/json", "application/xml" }
    )
    
    ResponseEntity<User> getUserId(
        @Min(0L) @Parameter(name = "id", description = "The ID of object to be returned", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    );


    /**
     * GET /users/roles/{id} : Get User with his Roles from ID
     * Get user (with roles) by his ID.
     *
     * @param id The ID of object to be returned (required)
     * @return Successful operation (status code 200)
     *         or Invalid id supplied (status code 400)
     *         or User not found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getUserIdWithRoles",
        summary = "Get User with his Roles from ID",
        description = "Get user (with roles) by his ID.",
        tags = { "User" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @GetMapping(
        value = "/users/roles/{id}",
        produces = { "application/json", "application/xml" }
    )
    
    ResponseEntity<User> getUserIdWithRoles(
        @Min(0L) @Parameter(name = "id", description = "The ID of object to be returned", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    );


    /**
     * GET /users : Gets all User
     * Gets all users present.
     *
     * @return Successful operation (status code 200)
     *         or Users not found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getUsers",
        summary = "Gets all User",
        description = "Gets all users present.",
        tags = { "User" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class))),
                @Content(mediaType = "application/xml", array = @ArraySchema(schema = @Schema(implementation = User.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Users not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = ApiError.class))
            })
        }
    )
    @GetMapping(
        value = "/users",
        produces = { "application/json", "application/xml" }
    )
    
    ResponseEntity<PagedModel<EntityModel<User>>> getUsers(@ParameterObject final Pageable pageable,
        final PagedResourcesAssembler<User> pagedResourcesAssembler
    );

}
